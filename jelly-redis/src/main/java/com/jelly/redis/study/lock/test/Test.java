package com.jelly.redis.study.lock.test;

import com.jelly.redis.study.lock.RedisLockUtils;

public class Test {
    public static void main(String[] args) {
        RedisLockUtils redisLockUtils=new RedisLockUtils();
        for (int i=0;i<50;i++){
            ThreadA threadA=new ThreadA(redisLockUtils);
            threadA.start();
        }
    }
}

