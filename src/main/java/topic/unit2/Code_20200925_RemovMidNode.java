package main.java.topic.unit2;

/**
 * 删除链表的中间节点和a/b处的节点
 *
 * @Author: liuy
 * @Date: 2020/9/25 15:26
 * @Description:
 */
public class Code_20200925_RemovMidNode {

    /**
     * 删除链表的中间节点
     */
    private Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        Node mid = head;
        Node last = head.next.next;
        while (mid.next != null && last.next.next != null) {
            mid = mid.next;
            last = last.next.next;
        }
        mid.next = mid.next.next;
        return head;
    }


    /**
     * 删除链表a/b处的节点
     */
    private Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }

        int num = 1;
        Node count = head.next;
        while (count != null) {
            num++;
            count = count.next;
        }

        num = (int) Math.ceil((num * a) / b);

        if (num == 1) {
            head = head.next;
        }

        if (num < 1) {
            Node cur = head;
            while (--num != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    private static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
        }
    }

}
