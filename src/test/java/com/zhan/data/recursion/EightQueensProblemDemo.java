package com.zhan.data.recursion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/9/20 17:54
 * 八皇后问题的小demo
 */
@SpringBootTest
public class EightQueensProblemDemo {

    @Test
    void demo() {
        EightQueensProblem queensProblem = new EightQueensProblem(8);
        System.out.println("八皇后问题的所有解法为------------");
        queensProblem.putQueen(1);
        System.out.printf("八皇后问题一共有%d种解法", queensProblem.getAnswer());
        System.out.printf("一共递归了%d次", queensProblem.getCount());
    }
}
