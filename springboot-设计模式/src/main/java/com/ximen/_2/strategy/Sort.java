package com.ximen._2.strategy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author zhishun.cai
 * @date 2020/6/14 10:23
 * @note
 */
public class Sort {
    public static void asc(Comparable[] arr){
        doSortAsc(arr);
    }

    public static void doSortAsc(Comparable[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = 0 ; j < arr.length - i -1 ; j ++){
                if(arr[j].compareTo(arr[j+1]) == 1){
                    Comparable temp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Cat[] d = new Cat[]{new Cat(3), new Cat(2),new Cat(1)};
        Sort.asc(d);
        System.out.println(Arrays.toString(d));
    }

}
