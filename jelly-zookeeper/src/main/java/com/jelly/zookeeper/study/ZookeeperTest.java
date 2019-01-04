package com.jelly.zookeeper.study;

import org.I0Itec.zkclient.ZkClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class ZookeeperTest {


    private  static  String url;
    static
    {
        Properties pro=new Properties();
        InputStream inputStream=ZookeeperTest.class.getClassLoader().getResourceAsStream("zookeeper.properties");
        try {
            pro.load(inputStream);
            url=pro.getProperty("zookeeper.url");
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

    public static void curator() throws Exception {
        CuratorFramework client= CuratorFrameworkFactory.newClient(url,new RetryNTimes(10,5000));
        client.start();
        List<String> children=client.getChildren().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent watchedEvent) throws Exception {
                System.out.println("监控： " + watchedEvent);
            }
        }).forPath("/");

        System.out.println(children);
        String  result = client.create().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath("/country/test", "Data".getBytes());

        System.out.println(result);
        client.setData().forPath("/country/test","55".getBytes());
        client.setData().forPath("/country/test","555".getBytes());
        System.out.println("abc:"+client.checkExists().forPath("/country"));
        client.close();
        System.out.println("ok");
    }

    public static void main(String[] args) throws Exception {


        ZookeeperTest.orgin();
        System.out.println("===============================");
        ZookeeperTest.curator();
        System.out.println("===============================");
        ZookeeperTest.zk101tec();


    }

    public  static  void orgin() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk=new ZooKeeper(url, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("监控： " + watchedEvent);
            }
        });
        System.out.println("OK");
        zk.create("/country","China".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        zk.create("/country/city","China/Beijing".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        zk.create("/country/view","balalba".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

        System.out.println(zk.getData("/country",false, null).toString());
        System.out.println(zk.getChildren("/country", true));


        zk.close();
    }

    public  static  void zk101tec(){
        ZkClient zkClient=new ZkClient(url);
        zkClient.create("/country/tec","1351111111",CreateMode.PERSISTENT);
        String str=zkClient.readData("/country/tec");
        System.out.println(str);
    }
}
