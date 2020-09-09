package com.zhan.data;

import com.zhan.data.queue.RingQueue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @Author Zhanzhan
 * @Date 2020/9/5 17:30
 * 数组模拟环形队列demo
 */
@SpringBootTest
public class RingQueueDemo {
    @Test
    void demo() {
        /**
         * 这里原本的设计中，数组要预留一个空间，即队列的最大数永远比数组小1，
         */
        RingQueue demo = new RingQueue(3);
        String key = ""; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s：显示队列");
            System.out.println("a：添加一个数据到队列");
            System.out.println("g：从队列中取出数据");
            System.out.println("h：查看队列的头数据");
            System.out.println("e：退出");
            System.out.print("选择功能：");
            key = scanner.next();
            switch (key) {
                case "s":
                    demo.showQueue();
                    break;
                case "a":
                    System.out.println("输入一个数据：");
                    int value = scanner.nextInt();
                    demo.addQueue(value);
                    break;
                case "g":
                    try {
                        int data = demo.getQueue();
                        System.out.println("取出的数据为：" + data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        int data = demo.headQueue();
                        System.out.println("队列的头数据为：" + data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println();
        }
        System.out.println("程序退出");
    }
}
