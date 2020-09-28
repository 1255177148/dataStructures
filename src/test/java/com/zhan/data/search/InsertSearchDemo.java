package com.zhan.data.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/9/28 21:03
 * 插值查找demo
 */
@SpringBootTest
public class InsertSearchDemo {
    @Test
    void demo() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i * 2;
        }

        InsertSearch insertSearch = new InsertSearch();
        int index = insertSearch.insertSearch(arr, 0, arr.length - 1, 2);
        System.out.println("找到的下标为:" + index);
    }
}
