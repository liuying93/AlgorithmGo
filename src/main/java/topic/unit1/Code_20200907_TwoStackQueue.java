package main.java.topic.unit1;


import java.util.Stack;

/**
 * 由两个栈组成的队列
 *
 * @Author: liuy
 * @Date: 2020/9/7 15:30
 * @Description:
 */
public class Code_20200907_TwoStackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public Code_20200907_TwoStackQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    public void add(int num) {
        pushStack.push(num);
    }

    public int poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

   /* public static void main(String[] args) {
        Code_20200907_TwoStackQueue obj = new Code_20200907_TwoStackQueue();
        int[] arr = {3, 1, 4, 5, 6, 1, 0, 4};
        for (int i = 0; i < arr.length; i++) {
            obj.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Min:" + obj.peek());
            System.out.println("Pop:" + obj.poll());
        }
    }*/
}
