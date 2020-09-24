package main.java.topic.unit1;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的 MAXTREE
 *
 * @Author: liuy
 * @Date: 2020/9/17 17:18
 * @Description:
 */
public class Code_20200917_GetMaxTree {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Node n = getMaxTree(arr);
        System.out.println(n.getValue());
    }

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lMap = new HashMap<>();
        HashMap<Node, Node> rMap = new HashMap<>();

        //左边第一个比它大的元素
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            while (!(stack.isEmpty()) && stack.peek().getValue() < curNode.getValue()) {
                popStackSetMap(stack, lMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lMap);
        }

        //右边第一个比它大的元素
        for (int i = nArr.length - 1; i >= 0; i--) {
            Node curNode = nArr[i];
            while (!(stack.isEmpty()) && stack.peek().getValue() < curNode.getValue()) {
                popStackSetMap(stack, rMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, rMap);
        }

        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lMap.get(curNode);
            Node right = rMap.get(curNode);

            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.getLeft() == null) {
                    right.setLeft(curNode);
                } else {
                    right.setRight(curNode);
                }

            } else if (right == null) {
                if (left.getLeft() == null) {
                    left.setLeft(curNode);
                } else {
                    left.setRight(curNode);
                }
            } else {
                Node parent = left.getValue() < right.getValue() ? left : right;
                if (left.getLeft() == null) {
                    left.setLeft(parent);
                } else {
                    left.setRight(parent);
                }
            }
        }
        return head;
    }


    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

}


class Node {
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int data) {
        this.value = data;
    }

}
