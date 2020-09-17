package com.zhan.data.stack;

import com.zhan.data.stack.ArrayStack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @Author zhan
 * @Date 2020/9/14 21:13
 * 用数组模拟栈的demo
 */
@SpringBootTest
public class ArrayStackDemo {

    @Test
    void demo() {
        ArrayStack<String> arrayStack = new ArrayStack<>(5, String.class);
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
                    arrayStack.list();
                    break;
                case "a":
                    System.out.println("输入一个数据：");
                    String value = scanner.next();
                    arrayStack.push(value);
                    break;
                case "g":
                    String result = arrayStack.pop();
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
