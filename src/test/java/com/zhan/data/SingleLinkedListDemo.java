package com.zhan.data;

import com.zhan.data.linkedlist.Node;
import com.zhan.data.linkedlist.SingleLinkedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/9/6 12:04
 * 单链表demo
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
        singleLinkedList.list();

        singleLinkedList.getNodeByIndex(7);
    }
}
