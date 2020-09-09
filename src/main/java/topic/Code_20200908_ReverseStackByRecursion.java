package main.java.topic;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 * 不能借助其他数据结构，包括新建一个栈
 *
 * @Author: liuy
 * @Date: 2020/9/8 17:26
 * @Description:
 */
public class Code_20200908_ReverseStackByRecursion {

    private static Stack<Integer> reverseStack;

    Code_20200908_ReverseStackByRecursion() {
        reverseStack = new Stack<>();
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }

        int last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int j = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(j);
    }

    public static void main(String[] args) {
        Code_20200908_ReverseStackByRecursion obj = new Code_20200908_ReverseStackByRecursion();
        reverseStack.push(1);
        reverseStack.push(2);
        reverseStack.push(3);
        reverseStack.stream().forEach(System.out::println);
        reverse(reverseStack);
        System.out.println("=========== after reverse =============");
        reverseStack.stream().forEach(System.out::println);

    }
}
