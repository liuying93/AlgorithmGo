package main.java.sort;

/**
 * 快速排序
 *
 * @Author: liuy
 * @Date: 2020/9/7 11:40
 * @Description:
 */
public class Code_04_QuickSort {
    public static void quickSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }

        swap(arr, R, more);
        return new int[]{less + 1, more};
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
