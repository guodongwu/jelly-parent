package com.jelly.algorithms.basestudy.sort;

import java.util.Arrays;

/**
 *把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 */
public class MergeSort {
    public  static  int[] mergeSort(int[] array){
        if(array.length<2) return  array;
        int mid=array.length/2;
        int []left= Arrays.copyOfRange(array,0,mid);
        int []right=Arrays.copyOfRange(array,mid,array.length);
        return  merge(mergeSort(left),mergeSort(right));

    }
    public  static  int []merge(int[] left,int[] right){
        int []result=new int [left.length+right.length];
        for(int index=0,i=0,j=0; index<result.length;index++){
            if(i>=left.length)
                result[index]=right[j++];
            else if(j>right.length)
                result[index]=left[i++];
            else if(left[i]>right[j])
                result[index]=right[j++];
            else
                result[index]=left[i++];
        }
        return  result;
    }
}
