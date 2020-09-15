package main.java.topic.unit1;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *
 * @Author: liuying
 * @Date: 2020/9/7 11:32
 * @Description:
 */
public class Code_20200907_GetMin {

    /*public static void main(String[] args) {
        Code_20200907_GetMin_02 obj = new Code_20200907_GetMin_02();
        int[] arr = {3, 1, 4, 5, 6, 1, 0, 4};
        for (int i = 0; i < arr.length; i++) {
            obj.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Min:" + obj.getMin());
            System.out.println("Pop:" + obj.pop());
        }
    }*/


    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Code_20200907_GetMin() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int num) {
        if (minStack.isEmpty()) {
            minStack.push(num);
        } else if (minStack.peek() >= num) {
            minStack.push(num);
        }

        dataStack.push(num);
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        if (dataStack.peek() == getMin()) {
            minStack.pop();
        }
        return dataStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

}

class Code_20200907_GetMin_02 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Code_20200907_GetMin_02() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int num) {
        if (minStack.isEmpty()) {
            minStack.push(num);
        } else if (minStack.peek() < num) {
            minStack.push(minStack.peek());
        } else if (minStack.peek() >= num) {
            minStack.push(num);
        }

        dataStack.push(num);
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

}
