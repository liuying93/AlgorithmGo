package main.java.sort;

/**
 * 归并排序
 *
 * @Author: liuy
 * @Date: 2020/9/7 11:39
 * @Description:
 */
public class Code_03_MergeSort {
    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int mid = (arr.length - 1) >> 1;
        merge(arr, 0, mid);
        merge(arr, mid + 1, arr.length - 1);
    }


    public static void merge(int[] arr, int i, int j) {
        if (j - i < 2) {
            return;
        }
        int mid = i + (j - i) >> 1;
        merge(arr, i, mid);
        merge(arr, mid + 1, j);
        if (arr[i] > arr[j]) {
            swap(arr, i, j);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
