package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author zhan
 * @Date 2020/9/26 21:35
 * 基数排序demo
 */
@SpringBootTest
public class BaseSortDemo {
    @Test
    void demo() {
        int[] arr = {3,6,23,666,6666,25,0};
        BaseSort baseSort = new BaseSort();
        baseSort.baseSort(arr);
        System.out.println("基数排序后的数组为:" + Arrays.toString(arr));
    }
}
