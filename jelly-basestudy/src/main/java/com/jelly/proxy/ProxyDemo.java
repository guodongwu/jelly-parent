package com.jelly.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

class ProxyTest{
    public static void main(String[] args) {
        Object[] elements=new Object[1000];
        for (int i=0;i<elements.length;i++){
            Integer val=i+1;
            InvocationHandler handler=new ProxyDemo(val);
            Object proxy= Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i]=proxy;
        }
        Integer key=new Random().nextInt(elements.length)+1;
        System.out.println("key"+key);
        int result= Arrays.binarySearch(elements,key);
        if(result>0) {
            System.out.println("elements:"+elements[result]);
        }
    }
}
class ProxyDemo implements InvocationHandler {
    private  Object target;

    public  ProxyDemo (Object obj){
        target=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("."+method.getName()+"(");
        if(args!=null){
            for (int i=0;i<args.length;i++){
                System.out.println(args[i]);
                if(i<args.length-1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print(")");
        System.out.println(" ");
        return method.invoke(target,args);
    }
}
