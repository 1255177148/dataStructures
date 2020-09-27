package com.zhan.data.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/9/27 20:22
 * 线性查找demo
 */
@SpringBootTest
public class LinearSearchDemo {
    @Test
    void demo() {
        LinearSearch linearSearch = new LinearSearch();
        int[] arr = {1,4,-1,5,7,9};
        int index = linearSearch.search(arr, 5);
        System.out.println("要查找的数在数组中的下标为:" + index);
    }
}
