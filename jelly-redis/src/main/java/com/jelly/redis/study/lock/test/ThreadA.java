package com.jelly.redis.study.lock.test;

import com.jelly.redis.study.lock.RedisLockUtils;

public class ThreadA  extends  Thread{

    private RedisLockUtils redisLockUtils;
    public  ThreadA(RedisLockUtils redisLockUtils){
        this.redisLockUtils=redisLockUtils;
    }
    @Override
    public  void run(){
        redisLockUtils.seckill();
    }
}
