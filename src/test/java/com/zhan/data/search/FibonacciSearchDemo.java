package com.zhan.data.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/9/29 20:52
 * 斐波那契查找demo
 */
@SpringBootTest
public class FibonacciSearchDemo {
    @Test
    void demo() {
        int[] arr = {1, 8, 10, 89, 1000};
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        int index = fibonacciSearch.fibonacciSearch(arr, 1);
        System.out.println("查到的下标为:" + index);
    }
}
