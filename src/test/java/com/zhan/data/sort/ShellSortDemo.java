package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author zhan
 * @Date 2020/9/22 21:52
 * 希尔排序demo
 */
@SpringBootTest
public class ShellSortDemo {
    @Test
    void demo() {
        ShellSort shellSort = new ShellSort(10);
        System.out.println("初始化的数组为:" + Arrays.toString(shellSort.getArr()));
        shellSort.sortByChange();
        System.out.println("排序后的数组为:" + Arrays.toString(shellSort.getArr()));
    }

    @Test
    void timeDemo() {
        ShellSort shellSort = new ShellSort(80000);
        shellSort.sortByChange();
    }

    @Test
    void timeTest() {
        ShellSort shellSort = new ShellSort(8000000);
        shellSort.sortByMove();
    }
}
