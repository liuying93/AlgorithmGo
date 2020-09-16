package main.java.topic.unit1;

/**
 * 汉诺塔问题
 * 递归方式求解
 *
 * @Author: liuy
 * @Date: 2020/9/15 17:13
 * @Description:
 */
public class Code_20200915_HanoiProblem1 {

    public static void main(String[] args) {
        int s = hanoiProblem1(4, "Left", "Right", "Mid");
        System.out.println(s);
    }


    public static int hanoiProblem1(int num, String left, String right, String mid) {
        if (num < 1) {
            return 0;
        }

        int result = process(num, left, right, mid, left, right);
        return result;
    }


    private static int process(int num, String left, String right, String mid, String from, String to) {
        if (num == 1) {
            if (mid.equals(from) || mid.equals(to)) {
                System.out.println("Move  1  from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move  1  from " + from + " to " + mid);
                System.out.println("Move  1  from " + mid + " to " + to);
                return 2;
            }
        }

        if (mid.equals(from) || mid.equals(to)) {
            String another = (left.equals(from) || left.equals(to)) ? right : left;
            int step1 = process(num - 1, left, right, mid, from, another);
            System.out.println("Move " + num + "  from  " + from + " to " + mid);
            int step2 = 1;
            int step3 = process(num - 1, left, right, mid, another, to);
            return step1 + step2 + step3;
        } else {
            int step1 = process(num - 1, left, right, mid, from, to);
            System.out.println("Move " + num + "  from  " + from + " to " + mid);
            int step2 = 1;
            int step3 = process(num - 1, left, right, mid, to, from);
            System.out.println("Move " + num + "  from  " + mid + " to " + to);
            int step4 = 1;
            int step5 = process(num - 1, left, right, mid, from, to);
            return step1 + step2 + step3 + step4 + step5;
        }


    }

}
