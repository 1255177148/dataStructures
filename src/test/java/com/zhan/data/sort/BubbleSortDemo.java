package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author Zhanzhan
 * @Date 2020/9/21 20:53
 * 冒泡排序demo
 */
@SpringBootTest
public class BubbleSortDemo {

    @Test
    void demo() {
        BubbleSort bubbleSort = new BubbleSort(80000);
//        System.out.println("初始化的数组为:" + Arrays.toString(bubbleSort.getArr()));
        bubbleSort.sort(true);
    }

    /**
     * 对比下优化与不优化的区别
     */
    @Test
    void contrast() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        bubbleSort.setArr(arr);
        bubbleSort.setSize(10);
        System.out.println("初始化的数组为:" + Arrays.toString(arr));
        System.out.println("使用优化过的冒泡排序-----------------");
        bubbleSort.sort(true);
        System.out.println("不使用优化的冒泡排序-----------------");
        bubbleSort.sort(false);
    }
}
