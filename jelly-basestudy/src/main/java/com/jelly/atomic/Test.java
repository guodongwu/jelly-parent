package com.jelly.atomic;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Test {
    static AtomicInteger i=new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {

        System.out.println(i.get());
        System.out.println(i.incrementAndGet());
        System.out.println(i.getAndIncrement());
        System.out.println(i.decrementAndGet());
        System.out.println(i.getAndDecrement());
        System.out.println(i.getAndAdd(5));
        System.out.println(i.addAndGet(5));
        System.out.println(i.getAndSet(0));
        System.out.println(i.get());
        Thread []ts=new Thread[10];
        for (int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        for (int k=0;k<10;k++){
            ts[k].start();
        }
        for (int k=0;k<10;k++){
            ts[k].join();
        }
        System.out.println(i);
        System.out.println("======================");
        for (int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    try{
                        Thread.sleep(Math.abs((int)(Math.random()*100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(attxnicStr.compareAndSet("abc","def")){
                        System.out.println("Thread:"+Thread.currentThread().getId()+"change:"+attxnicStr.get());
                    }else{
                        System.out.println("Thread:"+Thread.currentThread().getId()+"change failed "+attxnicStr.get());
                    }
                }
            }.start();
        }

    }
    public static class  AddThread implements Runnable{

        @Override
        public void run() {
            for (int k=0;k<10000;k++){
                i.incrementAndGet();
            }
        }
    }

    //2 AtomicReference
    final  static AtomicReference<String> attxnicStr=new AtomicReference<>("abc");

}
