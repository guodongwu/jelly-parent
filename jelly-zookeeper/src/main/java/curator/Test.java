package curator;

import com.jelly.zookeeper.study.发布订阅.Publish;
import com.sun.corba.se.impl.orbutil.StackImpl;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.util.Properties;

public class Test {
    static CuratorFramework curatorFramework;
    static {
        Properties pro=new Properties();
        InputStream inputStream= Publish.class.getClassLoader().getResourceAsStream("zookeeper.properties");
        try {
            pro.load(inputStream);
            String url=pro.getProperty("zookeeper.url");
            Integer sessionTimeOut= Integer.valueOf(pro.getProperty("zookeeper.sessionTimeout"));
            curatorFramework=CuratorFrameworkFactory.builder()
                    .connectString(url)
                    .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                    .sessionTimeoutMs(sessionTimeOut).build();
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

    public static void main(String[] args) throws Exception {
        String path="/publish";
        curatorFramework.start();
        Stat stat=curatorFramework.checkExists().forPath(path);
        if(null==stat){
            curatorFramework.create().forPath(path,"root".getBytes());
        }
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath(path);
        System.out.println(new String(bytes));
        curatorFramework.close();
    }
}
