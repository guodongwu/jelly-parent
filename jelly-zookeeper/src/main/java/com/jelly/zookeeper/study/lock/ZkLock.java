package com.jelly.zookeeper.study.lock;

import com.jelly.zookeeper.study.utils.PropertiesUtils;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public class ZkLock {
    public  String LOCK_PATH;
    public String beforeNode;
    public  String currentNode;

    public String threadTag=null;

    public static ZkClient client=new ZkClient(PropertiesUtils.ZOOKEEPER_IP_PORT,PropertiesUtils.SESSIONTIMEOUT,PropertiesUtils.CONNCETTIMEOUT,new SerializableSerializer());
    private static  Object lock1=new Object();
    private static  Object lock2=new Object();
    public  ZkLock(){}
    public  void lock(){
        synchronized (lock1){
            if(!client.exists(LOCK_PATH)){
                client.createPersistent(LOCK_PATH);
            }
            if(!tryLock()){
                waitForLock();
            }
        }
    }
    public  void unlock(){
        synchronized (lock2){
            if(currentNode!=null){
                client.delete(currentNode);
                currentNode=null;
            }
        }
    }
    private boolean tryLock(){
        ZkClient zkClient=client;
        threadTag=zkClient.createEphemeralSequential(LOCK_PATH+"/","");
        List<String> children=zkClient.getChildren(LOCK_PATH);
        Collections.sort(children);
        currentNode=LOCK_PATH+"/"+children.get(0);
        if(threadTag.equals(currentNode)){
            return  true;
        }else{
            int wz=Collections.binarySearch(children,threadTag.substring(LOCK_PATH.length()+1));
            beforeNode=LOCK_PATH+"/"+children.get(wz-1);
        }
        return false;
    }
    private  void waitForLock(){
        final CountDownLatch latch=new CountDownLatch(1);
        final IZkDataListener listener=new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if(latch!=null && latch.getCount()>0){
                    latch.countDown();
                }
            }
        };
        ZkClient zkClient=client;
        if(zkClient.exists(beforeNode)){
            zkClient.subscribeDataChanges(beforeNode,listener);
            try {
                latch.await(PropertiesUtils.SESSIONTIMEOUT, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zkClient.unsubscribeDataChanges(beforeNode,listener);
            currentNode=threadTag;

        }
        beforeNode=null;
    }

}
