package com.zhan.data.linkedlist;


/**
 * @Author zhan
 * @Date 2020/9/12 22:21
 */
public class RingSingleLinkedList {
    private Node first;

    /**
     * 创建一个环形单链表
     *
     * @param num 节点个数
     */
    public void create(int num) {
        if (num < 1) {
            System.out.println("指定创建环形单链表的个数有问题");
            return;
        }
        Node current = null;
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i, "");
            if (i == 1) {
                first = node;
                first.setNext(first);
                current = first;
            } else {
                current.setNext(node);
                node.setNext(first);
                current = node;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node current = first;
        while (true) {
            System.out.printf("节点的编号为%d\n", current.getNo());
            if (current.getNext() == first){
                break;
            }
            current = current.getNext();
        }
    }
}
