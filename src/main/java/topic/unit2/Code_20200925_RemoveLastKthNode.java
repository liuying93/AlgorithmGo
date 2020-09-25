package main.java.topic.unit2;

/**
 * 在单链表或双链表中删除倒数第K个节点
 *
 * @Author: liuy
 * @Date: 2020/9/25 10:54
 * @Description:
 */
public class Code_20200925_RemoveLastKthNode {
    //单链表
    private static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    private static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth == 0) {
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (lastKth != 0) {
                cur = cur.next;
                lastKth++;
            }

            head = cur.next;
        }
        return head;
    }


    //双链表
    private static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode prev;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    private static DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth == 0) {
            head = head.next;
            head.prev = null;
        }

        if (lastKth < 0) {
            cur = head;
            while (lastKth != 0) {
                lastKth++;
                cur = cur.next;
            }
            head = cur.next;
            head.prev = cur.prev.prev;
        }
        return head;
    }
}



