package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author Zhanzhan
 * @Date 2020/9/21 22:20
 * 选择排序demo
 */
@SpringBootTest
public class SelectSortDemo {
    @Test
    void demo() {
        SelectSort selectSort = new SelectSort(10);
        System.out.println("初始化的数组为:" + Arrays.toString(selectSort.getArr()));
        selectSort.sort();
    }
}
