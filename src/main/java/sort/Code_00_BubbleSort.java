package main.java.sort;

/**
 * @Author: liuying
 * @Date: 2020/9/7 10:51
 * @Description:
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] arr) {

    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
