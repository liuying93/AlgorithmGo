package main.java.topic.unit2;

/**
 * 反转单向和双向链表
 *
 * @Author: liuy
 * @Date: 2020/9/25 16:30
 * @Description:
 */
public class Code_20200925_ReverseList {

    /**
     * 反转单向链表
     */
    public static Node reverseList(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head.prev = next;
            head = next;
        }
        return pre;
    }


    private static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    private static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode prev;

        public Node(int data) {
            this.value = data;
        }
    }

}
