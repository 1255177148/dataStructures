package com.zhan.data.linkedlist;

import lombok.Data;

/**
 * @Author zhan
 * @Date 2020/9/11 23:01
 * 双向链表节点
 */
@Data
public class DoubleNode {
    private int no;
    private String name;
    private DoubleNode next;
    private DoubleNode pre;

    public DoubleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
