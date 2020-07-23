package com.zw.shujujiegou;

public class InsertSort {
    public static void Sort(int array[]){
        for (int i = 0;i < array.length;i++ ){
            int key = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if(array[j] >key){
                    array[j+1] = array[j];
                }
                else {
                    break;
                }
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int array[] = {8, 2, 5, 3, 6, 7, 1, 9, 0};
        Sort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

}
