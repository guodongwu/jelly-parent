package com.jelly.zookeeper.study.发布订阅;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Subscribe implements Watcher {
    public Subscribe(){}
    private static ZooKeeper zk=null;
    static {
        Properties pro=new Properties();
        InputStream inputStream= Subscribe.class.getClassLoader().getResourceAsStream("zookeeper.properties");
        try {
            pro.load(inputStream);
            String url=pro.getProperty("zookeeper.url");
            Integer sessionTimeOut= Integer.valueOf(pro.getProperty("zookeeper.sessionTimeout"));
            zk= new ZooKeeper(url,sessionTimeOut,new Subscribe());

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

    @lombok.SneakyThrows
    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected==watchedEvent.getState()){
            if(Event.EventType.None==watchedEvent.getType() && watchedEvent.getPath()==null){
                latch.countDown();
            }else{
                byte[] newByte=zk.getData(watchedEvent.getPath(),true,stat);
                System.out.println("path:"+watchedEvent.getPath()+"\tdata has changed.\t new Data :"+new String(newByte));

            }
        }
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        String path="/publish";
        latch.await();
        System.out.println("zk connection");
        byte[] temp=zk.getData(path,true,stat);
        System.out.println("init data: publish node data"+new String(temp));
        int i=0;
        while (true){
            Thread.sleep(Integer.MAX_VALUE);
        }
    }
}
