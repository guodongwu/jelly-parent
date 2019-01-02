package com.jelly.algorithms.basestudy;

import java.util.Arrays;

/**
 * 二分法: 数组必须是有序的
 *
 */
public class BinarySearch {
    public  static  int rank(int key,int []a){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi=mid-1;
            else if(key>a[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]=new int[]{1,2,5,4,6,3,7,8,10,9};
        Arrays.sort(arr);
        int a= rank(4,arr);
        System.out.println(a);

    }
}
