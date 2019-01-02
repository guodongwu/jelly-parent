package com.jelly.algorithms.basestudy.sort;

/**
 * 冒泡排序
 * O(N*N)
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr=new int []{1,5,63,4,6,7};
        arr=bubble(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }
    public  static  int[] bubble(int[] array){
        if(array.length==0) return  array;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1-i;j++){
                if(array[j+1]<array[j]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return  array;
    }
}
