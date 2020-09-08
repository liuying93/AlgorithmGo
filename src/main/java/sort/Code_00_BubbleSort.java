package main.java.sort;

/**
 * 冒泡排序
 *
 * @Author: liuy
 * @Date: 2020/9/7 10:51
 * @Description:
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 此用法是有陷阱的，若i == 就，则结果都会变成0
     * 所以使用前提是 i <> j
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
