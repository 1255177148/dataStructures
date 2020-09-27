package com.zhan.data.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author zhan
 * @Date 2020/9/27 21:04
 * 二分查找demo
 */
@SpringBootTest
public class BinarySearchDemo {
    @Test
    void demo() {
        int[] arr = {1,8,12,15,266,1636,1636,1636,10000};
        BinarySearch binarySearch = new BinarySearch();
        List index = binarySearch.binarySearch(arr, 1636, 0, arr.length-1);
        System.out.println("要找的数的下标为:" + index);
    }
}
