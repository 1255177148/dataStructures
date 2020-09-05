package com.zhan.data.queue;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/9/5 16:59
 */
@Data
public class RingQueue {
    private int maxSize; //表示数组最大容量
    private int front; //队列头，指向队列头本身
    private int rear; //队列尾，指向队列尾后一位
    private int[] arr; //用于存放数据，模拟队列

    public RingQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == (front % maxSize);
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
        arr[rear] = n;
        // 将rear后移，要考虑循环放置数据，maxSize就是一个周期，所以要取模(取余)
        rear = (rear + 1) % maxSize;
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
        int data = arr[front];
        // 将front后移，要考虑循环放置，maxSize就是一个周期，所以要取模(取余)
        front = (front + 1) % maxSize;
        return data;
    }

    /**
     * 显示队列中的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据---");
            return;
        }
        int size = front + getEffectiveData();
        int first = front % maxSize;
        for (int i = first; i < size; i++) {
            System.out.printf("arr[%d]=%d\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    /**
     * 显示队列的头数据
     *
     * @return
     */
    public int headQueue() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

    /**
     * 获取当前队列有效数据个数
     *
     * @return
     */
    public int getEffectiveData() {
        return (rear + maxSize - front) % maxSize;
    }
}
