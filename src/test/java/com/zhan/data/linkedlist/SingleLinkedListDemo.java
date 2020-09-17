package com.zhan.data.linkedlist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/9/6 12:04
 * 单链表demo
 * 链表中，每个节点的都会有一个指针，指向下一个节点，彼此链接
 */
@SpringBootTest
public class SingleLinkedListDemo {

    /**
     * 测试下无序添加
     */
    @Test
    void add() {
        /**
         * 先创建节点
         */
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");

        /**
         * 创建链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.list();
    }

    /**
     * 测试下有序添加，从小到大的顺序
     */
    @Test
    void addByOrder() {
        /**
         * 先创建节点
         */
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");

        /**
         * 创建链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.list();
    }

    /**
     * 测试修改节点
     */
    @Test
    void update() {
        /**
         * 先创建节点
         */
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");

        /**
         * 创建链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.list();

        /**
         * 再修改节点
         */
        Node node3 = new Node(1, "王五");
        singleLinkedList.update(node3);
        System.out.println("修改后的链表为：");
        singleLinkedList.list();
    }

    /**
     * 测试删除节点
     */
    @Test
    void delete() {
        /**
         * 先创建节点
         */
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");

        /**
         * 创建链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.list();

        singleLinkedList.delete(1);

        System.out.println("删除后的链表为：");
        singleLinkedList.list();
    }

    /**
     * 单链表中获取倒数第k个数据
     */
    @Test
    void getByIndex() {

        /**
         * 创建链表
         */
        SingleLinkedList singleLinkedList = initialization();
        singleLinkedList.list();

        singleLinkedList.getNodeByIndex(7);
    }

    /**
     * 测试将单链表反转
     */
    @Test
    void reverse() {
        SingleLinkedList singleLinkedList = initialization();
        System.out.println("反转前的单链表为：");
        singleLinkedList.list();
        singleLinkedList.reverse(singleLinkedList.getHead());
        System.out.println("反转后的单链表为：");
        singleLinkedList.list();
    }

    /**
     * 将单链表逆序打印
     */
    @Test
    void reversePrint() {
        SingleLinkedList singleLinkedList = initialization();
        System.out.println("原链表为：");
        singleLinkedList.list();
        System.out.println("开始逆序打印------");
        singleLinkedList.reversePrint(singleLinkedList.getHead());
        System.out.println("逆序打印后的链表为：");
        singleLinkedList.list();
    }

    /**
     * 合并两个有序单链表，合并后的链表依然有序
     */
    @Test
    void mergeList() {
        SingleLinkedList list1 = initialization();
        System.out.println("合并前的第一个链表为：");
        list1.list();

        /**
         * 先创建节点
         */
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(3, "李四");
        Node node3 = new Node(5, "王五");
        Node node4 = new Node(7, "大脚");
        Node node5 = new Node(9, "尼古拉斯-赵四");
        Node node6 = new Node(11, "桃园F3");


        SingleLinkedList list2 = new SingleLinkedList();
        list2.addByOrder(node1);
        list2.addByOrder(node2);
        list2.addByOrder(node3);
        list2.addByOrder(node4);
        list2.addByOrder(node5);
        list2.addByOrder(node6);
        System.out.println("合并前的第二个链表为：");
        list2.list();

        System.out.println("合并链表------------");
        SingleLinkedList list = new SingleLinkedList();
        Node head = list.mergeList(list1.getHead(), list2.getHead());
        System.out.println("合并后的新链表为：");
        list.list(head);
    }

    /**
     * 初始化一个单链表
     * @return
     */
    private SingleLinkedList initialization(){
        /**
         * 先创建节点
         */
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");
        Node node3 = new Node(3, "王五");
        Node node4 = new Node(4, "大脚");
        Node node5 = new Node(5, "尼古拉斯-赵四");
        Node node6 = new Node(6, "桃园F3");

        /**
         * 创建链表
         */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node5);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node6);
        return singleLinkedList;
    }
}
