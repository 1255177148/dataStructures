package com.zhan.data;

import com.zhan.data.linkedlist.DoubleLinkedList;
import com.zhan.data.linkedlist.DoubleNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/9/11 23:33
 * 双向链表demo
 */
@SpringBootTest
public class DoubleLinkedListDemo {

    /**
     * 添加节点到双向链表的末尾
     */
    @Test
    void add() {
        DoubleLinkedList doubleLinkedList = initialization();
        System.out.println("添加节点后的链表为：");
        doubleLinkedList.list();
    }

    /**
     * 在双向链表中修改一个节点
     */
    @Test
    void update() {
        DoubleLinkedList doubleLinkedList = initialization();
        System.out.println("初始化的链表为：");
        doubleLinkedList.list();
        DoubleNode doubleNode = new DoubleNode(2, "修改");
        System.out.println("修改节点后的链表为：");
        doubleLinkedList.update(doubleNode);
        doubleLinkedList.list();
    }

    /**
     * 在双向链表中删除一个节点
     */
    @Test
    void delete() {
        DoubleLinkedList doubleLinkedList = initialization();
        System.out.println("初始化的链表为：");
        doubleLinkedList.list();
        System.out.println("删除一个位于中间的节点（即不位于头部和尾部）------");
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表为：");
        doubleLinkedList.list();
        System.out.println("删除一个位于头部的节点------");
        doubleLinkedList.delete(1);
        System.out.println("删除后的链表为：");
        doubleLinkedList.list();
        System.out.println("删除一个位于尾部的节点------");
        doubleLinkedList.delete(6);
        System.out.println("删除后的链表为：");
        doubleLinkedList.list();
    }

    /**
     * 有序向双向链表添加节点
     */
    @Test
    void addByOrder() {
        /**
         * 先创建节点
         */
        DoubleNode node1 = new DoubleNode(1, "张三");
        DoubleNode node2 = new DoubleNode(2, "李四");
        DoubleNode node3 = new DoubleNode(3, "王五");
        DoubleNode node4 = new DoubleNode(4, "大脚");
        DoubleNode node5 = new DoubleNode(5, "尼古拉斯-赵四");
        DoubleNode node6 = new DoubleNode(6, "桃园F3");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node6);
        doubleLinkedList.addByOrder(node5);

        System.out.println("有序添加节点后的链表为：");
        doubleLinkedList.list();
    }

    /**
     * 初始化一个双向链表
     * @return
     */
    private DoubleLinkedList initialization(){
        /**
         * 先创建节点
         */
        DoubleNode node1 = new DoubleNode(1, "张三");
        DoubleNode node2 = new DoubleNode(2, "李四");
        DoubleNode node3 = new DoubleNode(3, "王五");
        DoubleNode node4 = new DoubleNode(4, "大脚");
        DoubleNode node5 = new DoubleNode(5, "尼古拉斯-赵四");
        DoubleNode node6 = new DoubleNode(6, "桃园F3");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node5);
        doubleLinkedList.add(node6);

        return doubleLinkedList;
    }
}
