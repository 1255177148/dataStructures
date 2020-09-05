package com.zhan.data.queue;

import lombok.Data;

import java.util.Scanner;

/**
 * @Author Zhanzhan
 * @Date 2020/9/5 15:52
 */
@Data
public class ArrayQueue {
    private int maxSize; //表示数组最大容量
    private int front; //队列头，指向队列头的前一位
    private int rear; //队列尾，指向队列尾本身
    private int[] arr; //用于存放数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 向队列中添加数据
     *
     * @param n 要添加的数据
     */
    public void addQueue(int n) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据~");
            return;
        }
        rear++; // 让指向队列尾的数据+1
        arr[rear] = n;
    }

    /**
     * 从队列中取数据
     *
     * @return
     */
    public int getQueue() throws Exception {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        // 将指向队列头的数据+1
        front++;
        return arr[front];
    }

    /**
     * 显示队列中的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据---");
            return;
        }
        for (int data : arr) {
            System.out.print("队列中的数据依次为：" + data + "\t");
        }
        System.out.println();
    }

    /**
     * 显示队列的头数据
     * @return
     */
    public int headQueue() throws Exception{
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front+1];
    }
}
