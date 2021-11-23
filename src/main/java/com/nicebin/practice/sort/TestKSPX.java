package com.nicebin.practice.sort;

import java.util.Arrays;
/**
 * 快速排序
 * author lp
 * Date  2019.06.04
 */

public class TestKSPX {
    public static void KSPX(int [] arr){

        int l = 0;
        int h = arr.length - 1;
        KSPX(arr,l,h);
    }

    private static void KSPX(int[] arr, int l, int h) {
        if(l<h){
            //分区 返回分区界限索引
            int index = part(arr,l,h);
            //左分区快速排序
            KSPX(arr, l, index-1);
            //右分区快速哦哎嘘
            KSPX(arr, index+1, h);
        }
    }

    private static int part(int[] arr, int l, int h) {
        //指定i，j
        int i= l;
        int j = h;

        //指定基准数（第一个数）
        int x  = arr[l];
        while(i<j){

            while(arr[j]>=x && i<j){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            while(arr[i] <=x && i<j){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;
        return i;

    }

    public static void main(String[] args) {

        //定义一个无序数组
        int arr[] = {72,6,57,88,60,42,83,73,48,85};
        //输出无序数组
        System.out.println(Arrays.toString(arr));

        //快速排序
        KSPX(arr);
        //输出有序数组
        System.out.println(Arrays.toString(arr));
    }
}

