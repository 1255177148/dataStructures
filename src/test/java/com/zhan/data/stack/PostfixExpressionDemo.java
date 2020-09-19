package com.zhan.data.stack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author zhan
 * @Date 2020/9/18 19:49
 * 一个简单的后缀表达式(逆波兰表达式)demo
 */
@SpringBootTest
public class PostfixExpressionDemo {

    /**
     * 后缀表达式，依次扫描表达式，如果是数字(运算数),则直接入栈,
     * 如果是运算符，则从栈中pop出两个数字(运算符)，进行计算，将计算的结果再入栈,
     * 就这样直到表达式的结尾
     */
    @Test
    void demo() {
        // 先定义一个后缀表达式
        String expression = "3 4 + 2 * 2 - 2 /";

        // 将表达式转为一个数组，方便遍历
        List<String> list = Arrays.asList(expression.split(" "));

        Stack<String> stack = new Stack<>();
        // todo
    }
}
