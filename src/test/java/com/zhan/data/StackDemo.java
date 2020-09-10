package com.zhan.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

/**
 * @Author zhan
 * @Date 2020/9/10 20:29
 * 一个关于栈的小demo
 */
@SpringBootTest
public class StackDemo {

    @Test
    void demo() {
        // 栈是先入后出，现在就是做一个测试，来验证
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println("依次取出的数据为：");
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
