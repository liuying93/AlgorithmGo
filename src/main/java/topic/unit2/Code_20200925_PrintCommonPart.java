package main.java.topic.unit2;

/**
 * 打印两个有序列表的公共部分
 *
 * @Author: liuy
 * @Date: 2020/9/25 10:40
 * @Description:
 */
public class Code_20200925_PrintCommonPart {

    private static void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part:");
        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                System.out.print(head1.data + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    private static class Node {
        public int data;
        public Node next;

        public Node(int value) {
            this.data = value;
        }
    }
}



