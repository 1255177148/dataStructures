package com.zhan.data.linkedlist;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/9/6 11:42
 * 单链表的节点
 */
@Data
public class Node {
    private int no;
    private String name;
    private Node next; // 指向下一个节点

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
