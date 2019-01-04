package com.jelly.zookeeper.study.lock;

public class ZkLockUserCode extends ZkLock {
    public  ZkLockUserCode(){
        super.LOCK_PATH="/USER_CODE";
    }

    public static void main(String[] args) {
        ZkLock zkLock=new ZkLockUserCode();
       try {
           zkLock.lock();
           System.out.println("lalala");
       }catch (Exception e)
       {
           System.out.println("error");
       }finally {
           zkLock.unlock();
       }


    }
}
