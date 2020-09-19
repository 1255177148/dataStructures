package com.zhan.data.stack;

import com.zhan.data.util.CalculationUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/9/17 21:13
 * 利用栈来进行计算的demo，
 * 假设给定一个字符串：1+3+5*2-4/2，
 * 求计算的结果，这时可以用栈来处理
 */
@SpringBootTest
public class CalculatorStackDemo {

    @Test
    void demo() {
        // 先给定一个要计算的字符串表达式
        String expression = "-10-30+5*2-40/20";

        // 再创建两个栈，一个放数据，为数栈，一个放运算符，为符栈
        CalculatorStack<String> numStack = new CalculatorStack<>(10, String.class);
        CalculatorStack<String> operatorStack = new CalculatorStack<>(10, String.class);

        int index = 0;
        String num1; // 单次的运算数1
        String num2; // 单次的运算数2
        String operator; // 单次的运算符
        String result; // 单次运算的结果
        String pre = null; // 记录下上一个数据
        String single;

        // 开始扫描表达式，并入栈
        while (index < expression.length()) {
            // 依次得到expression的每个字符
            single = expression.substring(index, index + 1);

            // 然后判断取出的单个字符，是数字还是运算符
            if (CalculationUtil.isPriority(single)) {
                // 如果开头是一个负数，那么负数的“-”会被识别为运算符，那么在开头插入一个数字0
                if (index == 0){
                    numStack.push("0");
                }
                // 如果当前是运算符
                // 判断当前的符号栈是否为空，为空则直接入栈
                if (operatorStack.isEmpty()) {
                    // 直接入栈
                    operatorStack.push(single);
                } else {
                    /**
                     * 如果符号栈中有符号，就进行比较，如果当前的符号小于或者等于栈顶的符号，
                     * 则要从数栈里pop两个数据，再从符号栈里pop出一个运算符，
                     * 进行运算，将运算的结果入数栈，再将当前的运算符入符号栈
                     */
                    if (CalculationUtil.getPriority(single) <= CalculationUtil.getPriority(operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        result = CalculationUtil.calculation(num1, num2, operator);
                        numStack.push(String.valueOf(result));
                    }
                    operatorStack.push(single);
                }
            } else {
                // 如果当前是数字，则直接入栈
                // 先判断下是否为多位数
                if (pre == null || CalculationUtil.isPriority(pre)){
                    numStack.push(single);
                } else {
                    int num = Integer.parseInt(numStack.pop());
                    result = String.valueOf(num * 10 + Integer.parseInt(single));
                    numStack.push(String.valueOf(result));
                }

            }
            pre = single;
            index++;
        }

        // 扫描完毕，开始顺序的从符号栈和数栈中pop出相应的数和运算符，并运算
        while (!operatorStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            result = CalculationUtil.calculation(num1, num2, operator);
            numStack.push(String.valueOf(result));
        }

        System.out.printf("表达式%s=%s",expression, numStack.pop());
    }
}
