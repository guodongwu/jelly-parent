package com.jelly.basestudy;

public class ShareDataThread extends Thread {
    private int count=5;
    @Override
     public synchronized void run() {
        super.run();
        count--;
        System.out.println(currentThread().getName()+"-->"+count);
    }

    public static void main(String[] args) {
        ShareDataThread shareDataThread=new ShareDataThread();
        Thread a=new Thread(shareDataThread,"A");
        Thread b=new Thread(shareDataThread,"B");
        Thread c=new Thread(shareDataThread,"C");
        Thread d=new Thread(shareDataThread,"D");
        Thread e=new Thread(shareDataThread,"E");
        a.start();b.start();c.start();d.start();e.start();

    }
}
