package com.zhan.data.stack;

/**
 * @Author zhan
 * @Date 2020/9/17 20:54
 */
public class CalculatorStack<T> extends ArrayStack<T> {

    public CalculatorStack(int maxSize, Class<T> type) {
        super(maxSize, type);
    }

    /**
     * 返回运算符的优先级
     *
     * @param operator 运算符
     * @return 优先级
     */
    public int getPriority(char operator) {
        switch (operator) {
            case '+':
                return 0;
            case '-':
                return 0;
            case '*':
                return 1;
            case '/':
                return 1;
            default:
                return -1;
        }
    }

    /**
     * 判断是否为运算符
     *
     * @param operator 要判断的字符
     * @return
     */
    public boolean isPriority(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    /**
     * 计算
     * @param num1 运算符后面的数
     * @param num2 运算符前面的数
     * @param operator 运算符
     * @return 计算结果
     */
    public int calculation(int num1, int num2, char operator) {
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
