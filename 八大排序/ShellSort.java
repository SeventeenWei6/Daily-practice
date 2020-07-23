package com.zw.shujujiegou;

public class ShellSort {
    public static void Shell(int []arr,int n){
        for (int gap = n/2;gap > 0;gap = gap/2){
            for (int i = gap; i < n;i++){
                int j = i;
                while(j-gap >=0 &&arr[j]<arr[j-gap]){
                    //插入排序采用交换法
                      int temp = arr[j];
                      arr[j] = arr[j-gap];
                      arr[j-gap] =temp;
                      j-=gap;
                }
            }
        }
    }
}
