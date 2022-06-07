package com.jelly.zookeeper.study.发布订阅;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Publish implements Watcher {
    public Publish(){}
    private static  ZooKeeper zk=null;
    static {
        Properties pro=new Properties();
        InputStream inputStream= Publish.class.getClassLoader().getResourceAsStream("zookeeper.properties");
        try {
           pro.load(inputStream);
           String url=pro.getProperty("zookeeper.url");
           Integer sessionTimeOut= Integer.valueOf(pro.getProperty("zookeeper.sessionTimeout"));
           zk= new ZooKeeper(url,sessionTimeOut,new Publish());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static CountDownLatch latch=new CountDownLatch(1);
    private static Stat stat=new Stat();

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected== watchedEvent.getState()){
            System.out.println("receive watched event:"+watchedEvent);
            System.out.println(watchedEvent.getState());
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        String path="/publish";
        latch.await();
        System.out.println("zk connection");
        Stat stat = zk.exists(path, true);
        if (null==stat) {
            zk.create(path,"root".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }
        byte[] temp=zk.getData(path,true,stat);
        System.out.println("init data: publish node data "+ new String(temp));
        int i=0;
        while (true){
            System.out.println("publish new Data:"+i);
            zk.setData(path,String.valueOf(i).getBytes(StandardCharsets.UTF_8),-1);
            Thread.sleep(5000L);
            i++;
        }

    }
}
