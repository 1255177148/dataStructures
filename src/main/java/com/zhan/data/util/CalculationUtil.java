package com.zhan.data.util;

/**
 * @Author Zhanzhan
 * @Date 2020/9/19 11:31
 */
public class CalculationUtil {

    /**
     * 计算
     * @param num1 运算符后面的数
     * @param num2 运算符前面的数
     * @param operator 运算符
     * @return 计算结果
     */
    public static int calculation(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                return -1;
        }
    }
}
