package com.jelly.args;

public class ArgsTest {
    public  int sum(int ...args){
        int sum=0;
        for (int arg : args) {
            sum+=arg;
        }
        return sum;

    }
    public <T> void  show(T...args){
        for (T arg:args){
            System.out.println(arg.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ArgsTest argsTest=new ArgsTest();
        int sum=argsTest.sum(2,1,3,4,5);
        System.out.println(sum);
        argsTest.show('X',"xxx",1,ArgsTest.class);
    }
}
