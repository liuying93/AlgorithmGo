package main.java.sort;

/**
 * 插入排序
 *
 * @Author: liuy
 * @Date: 2020/9/7 11:39
 * @Description:
 */
public class Code_02_InsertSort {

    public static void InsetSert(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
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
