package com.zhan.data.stack;

/**
 * @Author zhan
 * @Date 2020/9/17 20:54
 */
public class CalculatorStack<T> extends ArrayStack<T> {

    public CalculatorStack(int maxSize, Class<T> type) {
        super(maxSize, type);
    }
}
