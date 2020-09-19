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
            case '-':
                return 0;
            case '*':
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

}
