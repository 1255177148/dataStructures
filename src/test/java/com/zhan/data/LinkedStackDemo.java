package com.zhan.data;

import com.zhan.data.linkedlist.Node;
import com.zhan.data.stack.LinkedStack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @Author zhan
 * @Date 2020/9/14 21:44
 * 用单向链表模拟栈demo
 */
@SpringBootTest
public class LinkedStackDemo {
    @Test
    void demo() {
        LinkedStack linkedStack = new LinkedStack();
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s：显示队列");
            System.out.println("a：添加一个数据到队列");
            System.out.println("g：从队列中取出数据");
            System.out.println("e：退出");
            System.out.print("选择功能：");
            key = scanner.next();
            switch (key) {
                case "s":
                    linkedStack.list();
                    break;
                case "a":
                    System.out.println("输入一个数据：");
                    String value = scanner.next();
                    Node node = new Node(0, value);
                    linkedStack.push(node);
                    break;
                case "g":
                    Node result = linkedStack.pop();
                    System.out.println("取出的数据为：" + result);
                    break;
                case "e":
                    loop = false;
                    System.out.println("退出程序！");
                    break;
                default:
                    break;
            }
        }
    }
}
