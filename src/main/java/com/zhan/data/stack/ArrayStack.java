package com.zhan.data.stack;

import lombok.Data;

import java.lang.reflect.Array;

/**
 * @Author zhan
 * @Date 2020/9/14 20:46
 * 用数组模拟一个栈
 */
@Data
public class ArrayStack<T> {
    private int maxSize;// 栈的大小
    private T[] stack;//数组，来模拟栈，数据都存放在此数组中
    private int top = -1;//表示栈顶，即数组的最后一位的下标

    public ArrayStack(int maxSize, Class<T> type) {
        this.maxSize = maxSize;
        stack = (T[]) Array.newInstance(type, maxSize);
    }

    /**
     * 栈是否已满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 向栈中压入数据
     *
     * @param value 要添加的数据
     */
    public void push(T value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈，将栈顶的值返回
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("栈已空");
            return null;
        }
        T value = stack[top];
        top--;
        return value;
    }

    /**
     * 查看栈顶，
     * 不会将栈顶的数据取出
     * @return
     */
    public T peek(){
        if (isEmpty()) {
            System.out.println("栈已空");
            return null;
        }
        return stack[top];
    }

    /**
     * 遍历栈
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
