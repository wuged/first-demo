package com.stjh.firstdemo.test;

import java.util.Stack;

/**
 * @Author: wuge
 * @Date: 2020/9/15
 */
public class Test {

    public static void main(String[] args) {
        // 构建单链表
        Node lastNode = new Node(8);
        Node node4 = new Node(7, lastNode);
        Node node3 = new Node(5, node4);
        Node node2 = new Node(2, node3);
        Node headNode = new Node(1, node2);

        Node node21 = new Node(4, node4);
        Node headNode1 = new Node(3, node21);
        System.out.println(getMeetNode(headNode, headNode1).data);
        /*print(reverse);*/

    }

    private static Node getMeetNode(Node head1, Node head2) {
        int size = size(head1);
        int size2 = size(head2);
        if (size == 0 || size2 == 0) {
            return null;
        }
        // 定义longer，shorter指针，先让long指针走size-size2的绝对值步
        // 循环两个指针一起走，指向相同的时候即为交点
        Node longer = (size - size2) >= 0 ? head1 : head2;
        Node shorter = (size - size2) < 0 ? head1 : head2;
        int abs = Math.abs(size - size2);
        for (int i = 0; i < abs; i++) {
            longer = longer.next;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    private static int size(Node headNode) {
        if (headNode == null) {
            return 0;
        }
        Node temp = headNode;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    public static void print(Node headNode) {
        Node temp = headNode;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static class Node {

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
