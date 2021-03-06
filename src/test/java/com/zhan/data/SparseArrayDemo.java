package com.zhan.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @Author Zhanzhan
 * @Date 2020/9/3 15:45
 * 数据结构--稀疏数组demo类
 */
@SpringBootTest
public class SparseArrayDemo {

    @Test
    void demo() throws IOException {
        /**
         * 创建一个原始的二维数组，模拟围棋
         * 0：表示没有棋子；1：表示黑子；2：表示白子
         */
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        // 输出原始的二维数组
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        /**
         * 将二维数组 转 稀疏数组
         */
        // 1、先遍历原始数组，找到有效数据的个数
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        // 2、创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
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

        /**
         * 将稀疏数组还原为二维数组
         */
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1;i<sparseArr.length;i++){
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 输入还原后的二维数组
        System.out.println("\n还原后的二维数组为-----------");
        for (int[] row : arr){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        /**
         * 将稀疏数组写入文件保存
         */
        System.out.println("\n将稀疏数组写入文件中-------------");
        File file = new File("F:\\arrayDemo.data");
        FileWriter writer = new FileWriter(file);
        for (int[] row : sparseArr){
            for (int data : row){
                writer.write(data + "\t"); // 逐行写入
            }
            writer.write("\r\n"); // 另起换行
        }
        writer.close();

        /**
         * 从文件中读取数据并还原为原始二维数组
         */
        System.out.println("\n从文件中读取并还原为原始二维数组~~~~~~~~~~~~~");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int fileRow = 0;
        int[][] originalArr = new int[0][];
        // 逐行读取
        while ((line = reader.readLine()) != null){
            String[] temp = line.split("\t");
            if (fileRow == 0){
                originalArr = new int[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];
            } else {
                originalArr[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = Integer.parseInt(temp[2]);
            }
            fileRow++;
        }
        // 输入还原后的二维数组
        for (int[] row : originalArr){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
