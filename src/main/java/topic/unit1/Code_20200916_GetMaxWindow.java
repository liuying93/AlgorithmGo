package main.java.topic.unit1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 * @Author: liuy
 * @Date: 2020/9/16 17:33
 * @Description:
 */
public class Code_20200916_GetMaxWindow {


    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] result = getMaxWindow(arr, 3);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }


    public static int[] getMaxWindow(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        int[] max = new int[arr.length - w + 1];
        LinkedList<Integer> win = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!win.isEmpty() && win.peekFirst() <= i - w) {
                win.pollFirst();
            }
            while (!win.isEmpty() && arr[win.peekLast()] <= arr[i]) {
                win.pollLast();
            }
            win.addLast(i);
            if (i >= w - 1) {
                max[i - w + 1] = arr[win.peekFirst()];
            }
        }
        return max;
    }
}
