package com.zhan.data;

import com.zhan.data.linkedlist.RingSingleLinkedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/9/12 23:08
 * 约瑟夫问题，详细可以百度
 */
@SpringBootTest
public class JosephDemo {

    /**
     * 先构建环形单链表
     */
    @Test
    void construct() {
        RingSingleLinkedList ringSingleLinkedList = new RingSingleLinkedList();
        ringSingleLinkedList.create(5);
        ringSingleLinkedList.show();
    }

    /**
     * 约瑟夫问题，查看出圈顺序
     */
    @Test
    void count() {
        // 首先创建一个环形单向链表
        RingSingleLinkedList ringSingleLinkedList = new RingSingleLinkedList();
        ringSingleLinkedList.create(10);
        System.out.println("创建的环形单向链表为：");
        ringSingleLinkedList.show();
        ringSingleLinkedList.count(3, 3, 10);
    }
}
