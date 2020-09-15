package main.java.topic.unit1;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 *
 * @Author: liuy
 * @Date: 2020/9/14 16:53
 * @Description:
 */
public class Code_20200914_StackOrderStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        if (null == stack || stack.size() < 2) {
            return;
        }

        Stack<Integer> help = new Stack();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            while (!help.isEmpty() && curr > help.peek()) {
                stack.push(help.pop());
            }
            help.push(curr);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        int[] arr = {3, 1, 4, 5, 6, 1, 0, 4};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
