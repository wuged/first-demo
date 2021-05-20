package com.stjh.firstdemo.test;

/**
 * @Author: wuge
 * @Date: 2020/9/17
 */
public class DoubleLinkedList {

    private Node headNode;

    private Node lastNode;

    private int size;

    public int size() {
        return this.size;
    }

    public void add(Object element) {
        // 构造成节点对象
        Node addNode = new Node(element);
        // 判断双链表是否为空表
        if (headNode == null) {
            headNode = addNode;
            lastNode = addNode;
        } else {
            lastNode.next = addNode;
            addNode.pre = lastNode;
            lastNode = addNode;
        }
        size++;
    }

    public void add(int index, Object element) {
        // 可以加到末尾，index可以取到size值
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界，index：" + index);
        }
        Node node = new Node(element);
        Node curNode = node(index);
        if (index == 0) {
            node.next = curNode;
            curNode.pre = node;
            headNode = node;
        } else if (index == size) {
            curNode.next = node;
            node.pre = curNode;
            lastNode = node;
        } else {
            Node pre = curNode.pre;
            pre.next = node;
            node.pre = pre;
            node.next = curNode;
            curNode.pre = node;
        }
        size++;
    }

    public void remove(int index) {
        checkIsLegal(index);
        Node curNode = node(index);
        if (index == 0) {
            // 找到第二个节点
            Node next = curNode.next;
            if (next != null) {
                next.pre = null;
            }
            headNode.next = null;
            headNode = next;
        } else if (index == size - 1) {
            Node pre = curNode.pre;
            pre.next = null;
            lastNode.pre = null;
            lastNode = pre;
        } else {
            Node pre = curNode.pre;
            Node next = curNode.next;
            pre.next = next.pre;
            next.pre = pre.next;
        }
        size--;
    }

    public Object get(int index) {
        checkIsLegal(index);
        return node(index).data;
    }

    private Node node(int index) {
        // 如果节点在前半区从前往后找，否则从后往前找
        Node temp = new Node(null);
        if (index < size / 2) {
            temp = headNode;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = lastNode;
            for (int i = size - 1; i > index; i--) {
                temp = temp.pre;
            }
        }
        return temp;
    }

    private void checkIsLegal(int index) {
        // 校验index是否合法
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("下标越界，index：" + index);
        }
    }

    /**
     * 静态内部类
     */
    public static class Node {

        private Node pre;

        private Node next;

        private Object data;

        public Node(Object data) {
            this.data = data;
        }

    }
}
