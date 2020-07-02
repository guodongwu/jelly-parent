package com.jelly.basestudy;

public class NoShareDataThread extends Thread{
    private int count=5;
    public NoShareDataThread(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count>0){
            count--;
            System.out.println(currentThread().getName()+"-->"+count);
        }
    }


    public static void main(String[] args) {
        NoShareDataThread a=new NoShareDataThread("A");
        NoShareDataThread b=new NoShareDataThread("B");
        NoShareDataThread c=new NoShareDataThread("C");
        a.start();
        b.start();
        c.start();

    }
}
