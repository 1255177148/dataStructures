package com.zhan.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/9/3 15:45
 * 数据结构--稀疏数组demo类
 */
@SpringBootTest
public class SparseArrayDemo {

    @Test
    void demo() {
        /**
         * 创建一个原始的二维数组，模拟围棋
         * 0：表示没有棋子；1：表示黑子；2：表示白子
         */
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        // 输出原始的二维数组
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组
        // 1、先遍历原始数组，找到有效数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    sum ++;
                }
            }
        }
        // 2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历二维数组，将有效数据存放到稀疏数组中
        int count = 0; //计数器，用来记录是第几个有效数据
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0]= i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        // 输出稀疏数组
        System.out.println("\n转化的稀疏数组为----------");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
