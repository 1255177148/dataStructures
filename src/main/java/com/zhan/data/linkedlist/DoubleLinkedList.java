package com.zhan.data.linkedlist;

/**
 * @Author zhan
 * @Date 2020/9/11 23:00
 * 双向链表
 */
public class DoubleLinkedList {
    private final DoubleNode head = new DoubleNode(0, "");

    /**
     * 获取头节点
     * @return 头节点
     */
    public DoubleNode getHead(){
        return head;
    }

    public void list(){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.getNext(); // 指针从头节点开始
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext(); // 指针后移
        }
    }

    public void list(DoubleNode head){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.getNext(); // 指针从头节点开始
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext(); // 指针后移
        }
    }

    /**
     * 向双向链表末尾添加一个节点
     * @param node 要添加的节点
     */
    public void add(DoubleNode node){
        DoubleNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
    }

    /**
     * 修改双向链表中的节点
     * @param node 要修改的节点
     */
    public void update(DoubleNode node){
        boolean find = false;
        DoubleNode temp = head.getNext();
        while (temp != null){
            if (temp.getNo() == node.getNo()){
                find = true;
                break;
            }
            temp = temp.getNext();
        }
        if (find){
            temp.setName(node.getName());
        } else {
            System.out.println("没有找到所要修改的节点");
        }
    }

    /**
     * 删除双向链表中的节点
     * @param no 要删除的节点
     */
    public void delete(int no){
        boolean find = false;
        DoubleNode temp = head.getNext();
        while (temp != null){
            if (temp.getNo() == no){
                find = true;
                break;
            }
            temp = temp.getNext();
        }
        if (find){
            temp.getPre().setNext(temp.getNext());
            if (temp.getNext() != null){
                temp.getNext().setPre(temp.getPre());
            }
        } else {
            System.out.println("没有找到要删除的节点");
        }
    }

    /**
     * 按顺序添加节点
     * @param node
     */
    public void addByOrder(DoubleNode node){
        boolean exist = false;
        DoubleNode temp = head;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() > node.getNo()){
                break;
            }
            if (temp.getNext().getNo() == node.getNo()){
                exist = true;
                break;
            }
            temp = temp.getNext();
        }
        if (exist){
            System.out.println("要添加的节点已存在");
            return;
        }
        if (temp.getNext() == null){
            temp.setNext(node);
            node.setPre(temp);
            return;
        }
        node.setNext(temp.getNext());
        node.setPre(temp);
        temp.getNext().setPre(node);
        temp.setNext(node);
    }
}
