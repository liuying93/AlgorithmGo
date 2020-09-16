package main.java.topic.unit1;

import java.util.Stack;

/**
 * 汉诺塔问题
 * 压栈方式求解
 *
 * @Author: liuy
 * @Date: 2020/9/15 17:18
 * @Description:
 */
public class Code_20200915_HanoiProblem2 {


    public static void main(String[] args) {
        int s = hanoiProblem2(4, "Left", "Right", "Mid");
        System.out.println(s);
    }


    private enum Action {
        No, LtoM, MtoL, RtoM, MtoR;
    }

    public static int hanoiProblem2(int num, String left, String right, String mid) {
        Stack<Integer> LS = new Stack<>();
        Stack<Integer> MS = new Stack<>();
        Stack<Integer> RS = new Stack<>();

        LS.push(Integer.MAX_VALUE);
        MS.push(Integer.MAX_VALUE);
        RS.push(Integer.MAX_VALUE);

        for (int i = num; i > 0; i--) {
            LS.push(i);
        }

        Action[] record = {Action.No};
        int step = 0;
        while (RS.size() < num + 1) {
            step += fStackTotStack(record, Action.MtoL, Action.LtoM, LS, MS, left, mid);
            step += fStackTotStack(record, Action.LtoM, Action.MtoL, MS, LS, mid, left);
            step += fStackTotStack(record, Action.RtoM, Action.MtoR, MS, RS, mid, right);
            step += fStackTotStack(record, Action.MtoR, Action.RtoM, RS, MS, left, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record, Action preNoAction, Action nowAction, Stack<Integer> fS, Stack<Integer> tS, String from, String to) {
        if (record[0] != preNoAction && fS.peek() < tS.peek()) {
            tS.push(fS.pop());
            record[0] = nowAction;
            System.out.println("Move " + tS.peek() + " from " + from + " to " + to);
            return 1;
        }
        return 0;
    }
}
