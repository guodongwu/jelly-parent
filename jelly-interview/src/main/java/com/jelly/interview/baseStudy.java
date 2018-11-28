package com.jelly.interview;

public class baseStudy {
    public static void main(String[] args) {
        String p1=new String("1");
        String p2=p1;
        String p3="1";
        System.out.println(p1.equals(p2));
        System.out.println(p1==p2);
        System.out.println();
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p1.equals(p3));
        System.out.println(p1==p3);
        System.out.println(test());

    }
    public static int test(){
        try{
            int i=1/0;
            return 1;
        }catch (Exception ec){
            return  2;
        }finally {
             return 3;
        }
    }
}
