package com.zhan.data.stack;

import com.zhan.data.linkedlist.Node;

/**
 * @Author zhan
 * @Date 2020/9/14 21:34
 * 用单向链表模拟栈
 */
public class LinkedStack {
    // 初始化一个头节点
    private final Node head = new Node(0, "");

    /**
     * 返回头节点
     * @return
     */
    public Node getHead(){
        return head;
    }

    /**
     * 向栈中压入数据
     * @param node 要添加的数据
     */
    public void push(Node node){
        Node temp = head.getNext();
        node.setNext(temp);
        head.setNext(node);
    }

    /**
     * 从栈顶取出数据
     * @return
     */
    public Node pop(){
        if (head.getNext() == null){
            System.out.println("栈为空");
            return null;
        }
        Node temp = head.getNext();
        head.setNext(temp.getNext());
        return temp;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if (head.getNext() == null){
            System.out.println("栈为空");
            return;
        }
        Node temp = head.getNext();
        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }
}
