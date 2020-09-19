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
    public static String calculation(String num1, String num2, String operator) {
        switch (operator) {
            case "+":
                return ArithmeticUtil.add(num1, num2, 2);
            case "-":
                return ArithmeticUtil.sub(num2, num1, 2);
            case "*":
                return ArithmeticUtil.mul(num1, num2, 2);
            case "/":
                return ArithmeticUtil.div(num2, num1, 2);
            default:
                return "-1";
        }
    }

    /**
     * 判断是否为运算符
     *
     * @param operator 要判断的字符
     * @return
     */
    public static boolean isPriority(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    /**
     * 返回运算符的优先级
     *
     * @param operator 运算符
     * @return 优先级
     */
    public static int getPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
