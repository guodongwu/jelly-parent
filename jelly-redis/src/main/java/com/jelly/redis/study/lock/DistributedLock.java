package com.jelly.redis.study.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;
import java.util.List;
import java.util.UUID;

public class DistributedLock {
    private  final JedisPool jedisPool;
    public  DistributedLock(JedisPool jedisPool){
        this.jedisPool=jedisPool;
    }
    /**
     * 加锁
     */
    public String lockWithTimeOut(String lockName,long acquireTimeout,long timeout){
        Jedis conn=null;
        String retIdentifier=null;
        try{
            conn=jedisPool.getResource();
            String identifier= UUID.randomUUID().toString();
            String lockKey="lock:"+lockName;
            int lockExpire=(int)(timeout/1000);
            long end=System.currentTimeMillis()+acquireTimeout;
            while (System.currentTimeMillis()<end){
                if(conn.setnx(lockKey,identifier)==1) {
                    conn.expire(lockKey, lockExpire);
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                if(conn.ttl(lockKey)==-1){
                    conn.expire(lockKey,lockExpire);
                }
                try
                {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }catch (JedisException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }
        return  retIdentifier;
    }

    /**
     * 释放锁
     */
    public  boolean releaseLock(String lockName,String identifier){
        Jedis conn=null;
        String lockKey="lock:"+lockName;
        boolean retFlag=false;
        try{
            conn=jedisPool.getResource();
            while(true){
                conn.watch(lockKey);
                if(identifier.equals(conn.get(lockKey))){
                    Transaction transaction=conn.multi();
                    transaction.del(lockKey);
                    List<Object> results=transaction.exec();
                    if(results==null){
                        continue;
                    }
                    retFlag=true;
                }
                conn.unwatch();
                break;
            }
        }catch (JedisException e){
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }
        return  retFlag;
    }
}
