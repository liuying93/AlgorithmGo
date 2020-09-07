package test.sort;

import main.java.sort.Code_03_MergeSort;

import java.util.Arrays;

/**
 * @Author: liuy
 * @Date: 2020/9/7 15:45
 * @Description:
 */
public class SortTest {

    private static int[] arr = {23, 1, -3, 5, 7, 0, 8, 0, 22, 99, 2};

    public static void main(String[] args) {
        /*Code_00_BubbleSort.bubbleSort(arr);*/
        /*Code_01_SelectionSort.selectionSort(arr);*/
        /*Code_02_InsertSort.InsetSert(arr);*/
        Code_03_MergeSort.mergeSort(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
    }


}
