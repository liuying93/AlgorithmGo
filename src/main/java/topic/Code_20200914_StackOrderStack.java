package main.java.topic;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 *
 * @Author: liuy
 * @Date: 2020/9/14 16:53
 * @Description:
 */
public class Code_20200914_StackOrderStack {

   /* private Stack stack;
    private Stack help;

    public Code_20200914_StackOrderStack() {
        this.stack = new Stack();
        this.help = new Stack();
    }*/


    public static void sortStackByStack(Stack<Integer> stack) {
        if (null == stack || stack.size() < 2) {
            return;
        }

        Stack<Integer> help = new Stack();
        int curr = stack.pop();
        help.push(curr);
        while (!stack.isEmpty()) {


        }


    }

}
