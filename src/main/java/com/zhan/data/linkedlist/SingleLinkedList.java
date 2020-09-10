package com.zhan.data.linkedlist;

import java.util.Stack;

/**
 * @Author Zhanzhan
 * @Date 2020/9/6 11:41
 * 一个单链表
 */
public class SingleLinkedList {
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
     * 向单链表中添加一个节点,不考虑顺序
     * 1、找到当前链表的最后节点
     * 2、将最后的这个节点的next指向新的节点
     * @param node 要添加的节点
     */
    public void add(Node node){
        // 因为head节点不能动，所以需要一个临时指针遍历
        Node temp = head;
        // 遍历链表，找到最后
        while (temp.getNext() != null) {
            // 如果没有找到，将temp后移
            temp = temp.getNext();
        }
        // 当退出循环时，temp就指向了链表的最后
        // 将最后的这个节点的next，指向新的节点
        temp.setNext(node);
    }

    /**
     * 向单链表中添加一个节点，考虑顺序
     * @param node 要添加的节点
     */
    public void addByOrder(Node node){
        Node temp = head;
        boolean exist = false;
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
            System.out.println("要添加的数据的序号已经存在");
        } else {
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    /**
     * 根据节点中的no字段来进行修改
     * @param node 要修改的节点
     */
    public void update(Node node){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.getNext();
        boolean find = false; // 标记是否找到该节点
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == node.getNo()){
                find = true;
                break;
            }
            temp = temp.getNext();
        }
        if (find){
            temp.setName(node.getName());
        } else {
            System.out.printf("没有找到编号为%d的节点", node.getNo());
        }
    }

    /**
     * 根据序号删除节点
     * 用一个指针遍历链表，当指针的next元素的no值和传入的序号一样时，就找到了要删除的元素的前一位，
     * 将前一位的next越过要删除的元素，直接指向删除元素的后一位
     * @param no
     */
    public void delete(int no){
        if (head.getNext() == null){
            System.out.println("链表为空，不用删");
            return;
        }
        Node temp = head;
        boolean find = false;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() == no){
                find = true;
                break;
            }
            temp = temp.getNext();
        }
        if (find){
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("要删除的节点不存在");
        }
    }

    public void list(){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.getNext(); // 指针从头节点开始
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext(); // 指针后移
        }
    }

    /**
     * 查找倒数第index个节点，
     * 这里实现的思路为：可以设置两个指针a和b，a、b间隔index个位置，即a从第一个位置遍历，b从第(index + 1)个位置遍历,
     * 然后当b指向最后一个位置的时候，a指向的位置的下一个节点就是倒数第index个节点，
     * 这样做的好处是只遍历一遍链表，节省时间
     * @param index
     * @return
     */
    public void getNodeByIndex(int index){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        Node tempFirst = head;
        Node tempEnd = head;
        int count = 0;
        boolean start = false; // 标记第一个指针是否已经开始往下走
        while (tempEnd.getNext() != null) {
            count++;
            if (count >= index) {
                tempFirst = tempFirst.getNext();
                start = true; // 标记第一个指针已经开始往下走了
            }
            tempEnd = tempEnd.getNext();
        }
        if (start){
            System.out.println("倒数第" + index + "个节点的数据为:" + tempFirst.toString());
        } else {
            System.out.println("没有找到倒数第" + index + "个节点");
        }
    }

    /**
     * 反转单链表
     * @param head
     */
    public void reverse(Node head){
        // 如果当前链表为空，或者只有一个节点，无需反转
        if (head.getNext() == null || head.getNext().getNext() == null){
            return;
        }
        Node current = head.getNext();// 这里表示当前节点，从第一个节点开始
        Node temp = null; // 临时保存下当前节点的指针
        Node pre = new Node(0, ""); // 定义上一节点
        while (current != null){
            temp = current.getNext(); // 临时保存下当前节点的指针
            current.setNext(pre.getNext()); // 将当前节点的指针指向上一节点
            pre.setNext(current); // pre节点前移
            current = temp; // 将临时保存的指针赋给current，即current节点遍历链表，依次取出链表中的数据
        }
        head.setNext(pre.getNext()); // 将头节点指向最终的pre节点
    }

    /**
     * 将链表逆序打印，
     * 不改变原链表的结构
     * @param head
     */
    public void reversePrint(Node head){
        // 如果当前链表为空，则不能逆序打印
        if (head.getNext() == null){
            System.out.println("空链表，无法打印");
            return;
        }
        Node current = head.getNext();
        Stack<Node> stack = new Stack<>();
        while (current != null){
            stack.push(current);
            current = current.getNext();
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
