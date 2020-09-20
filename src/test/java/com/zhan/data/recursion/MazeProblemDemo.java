package com.zhan.data.recursion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/9/20 15:13
 * 使用递归结果迷宫问题的demo
 */
@SpringBootTest
public class MazeProblemDemo {

    @Test
    void demo() {
        // 初始化一个迷宫
        MazeProblem maze = new MazeProblem(10, 10);
        System.out.println("初始化的迷宫地图为：");
        maze.showMap();
        System.out.println("从迷宫的左上角开始走迷宫----------");
        maze.findWay(1, 1);
        System.out.println("走过的轨迹为----------");
        maze.showMap();
    }
}
