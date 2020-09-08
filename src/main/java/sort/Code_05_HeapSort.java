package main.java.sort;

/**
 * 堆排序
 *
 * @Author: liuy
 * @Date: 2020/9/8 14:55
 * @Description:
 */
public class Code_05_HeapSort {

    public static void heapSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 建立大根堆
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从根开始向下堆化
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (heapSize > left) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > largest ? index : largest;
            if (index == largest) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
