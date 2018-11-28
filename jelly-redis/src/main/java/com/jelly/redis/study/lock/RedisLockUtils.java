package com.jelly.redis.study.lock;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisLockUtils {
    private static JedisPool pool=null;
    static {
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(200);
        config.setMaxWaitMillis(1000*100);
        config.setTestOnBorrow(true);
        pool=new JedisPool(config,"127.0.0.1",6379,3000);

    }
    DistributedLock lock=new DistributedLock(pool);
    int n=500;
    public  void seckill(){
        String identifier=lock.lockWithTimeOut("resource",5000,1000);
        System.out.println(Thread.currentThread().getName()+"获得了锁");
        System.out.println(--n);
        lock.releaseLock("resource",identifier);
    }
}
