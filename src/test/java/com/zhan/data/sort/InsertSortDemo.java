package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author Zhanzhan
 * @Date 2020/9/22 11:05
 * 插入排序demo
 */
@SpringBootTest
public class InsertSortDemo {
    @Test
    void demo() {
        InsertSort insertSort = new InsertSort(10);
        System.out.println("初始化的数组为:" + Arrays.toString(insertSort.getArr()));
        insertSort.sort();
        System.out.println("插入排序后的数组为:" + Arrays.toString(insertSort.getArr()));
    }

    /**
     * 测试下耗费的时间
     */
    @Test
    void timeDemo() {
        InsertSort insertSort = new InsertSort(80000);
        insertSort.sort();
    }
}
