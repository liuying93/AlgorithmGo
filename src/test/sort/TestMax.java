package test.sort;

public class TestMax {

    public static int getMax(int[] arr, int L, int R, String s) {
        System.out.println("L：" + L + " " + "R:" + R + " " + s);
        if (L == R) {
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr, L, mid, "L");
        int rightMax = getMax(arr, mid + 1, R, "R");
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 7};
        int result = getMax(arr, 0, arr.length - 1, "Start");
        System.out.println(result);
    }
}
