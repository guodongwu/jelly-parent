package com.jelly.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {

        int[] a=new int[]{1,2,3,4,5,6};
        final int[] b=a;
        int[] c= Arrays.copyOf(a,a.length);
        b[2]=7;
        System.out.println(a[2]);
        System.out.println(c[2]);


        List<Integer> list=new ArrayList<>();
        for(int i=0;i<9;i++){
            list.add(i);
        }
        int low=5;
        int high=list.size()-1;
        int mid=(high+low)>>>1;
        System.out.println(mid);
        int i=binarySearch(list,5);
        System.out.println(list);
        System.out.println(i);

    }

    public  static<T> int binarySearch(List<? extends Comparable<? super T>> list,T key){
        int low=0;
        int high=list.size()-1;
        while (low<=high){
            int mid=(high+low)>>>1;
            Comparable<? super T> midVal= list.get(mid);
            int cmp=midVal.compareTo(key);
            if(cmp<0){
                low=mid+1;
            }else if(cmp>0){
                high=mid-1;
            }else{
                return mid;
            }

        }
        return -1;

    }


}
