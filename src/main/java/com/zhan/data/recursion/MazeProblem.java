package com.zhan.data.recursion;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/9/20 14:28
 * 迷宫问题
 */
@Data
public class MazeProblem {

    private int[][] map;
    private int row;
    private int column;

    private static int count = 0;

    /**
     * 初始化一个迷宫
     *
     * @param row    有几行
     * @param column 有几列
     */
    public MazeProblem(int row, int column) {
        this.row = row;
        this.column = column;
        this.map = new int[row][column];// 初始化一个row行column列的迷宫阵型
        // 最左和最右两列全部变成墙
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][column - 1] = 1;
        }
        // 最上和最下两行全部变成墙
        for (int i = 0; i < column; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }
        // 然后每隔两行、每隔两列，就设置一个障碍，或者墙角
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < column; j++) {
                    if (j % 2 == 0) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        // 出口处以及周围不能设置为墙或者障碍物
        map[row - 2][column - 2] = 0;
        map[row - 2][column - 1] = 0;
        map[row - 1][column - 2] = 0;
        map[row - 1][column - 1] = 0;
    }

    /**
     * <p>使用递归回溯从迷宫中找路</p>
     * <p>步骤：
     * <blockquote><pre>
     *  1、i、j表示从地图上哪个位置出发;
     *  2、如果小球能找到map[row - 2][column - 2]位置，则说明成功找到出口;
     *  3、约定,map[i][j]的值：
     *      为0,表示该点没有走过并可以走;
     *      为1,表示该点为障碍物或者墙，不能走;
     *      为2,表示是通路，并且走过;
     *      为3,表示该点已经走过，并且走不通.
     *  4、走迷宫时,需要实现定一个策略,这里我们约定走的顺序为:下->右->上->左,如果该点走不通，在回溯回来重走.
     *  </pre></blockquote>
     * </p>
     *
     * @param i 地图的横坐标
     * @param j 地图的纵坐标
     * @return 是否找到出口
     */
    public boolean findWay(int i, int j) {
        count++;
        if (map[row - 1][column - 1] == 2) { // 出口已找到
            return true;
        }
        if (i >= row || j >= column){ // 出界了
            return false;
        }
        if (map[i][j] == 0) { // 如果当前这个点还没有走过
            map[i][j] = 2;
            if (findWay(i + 1, j)) {
                return true;
            } else if (findWay(i, j + 1)) {
                return true;
            } else if (findWay(i - 1, j)) {
                return true;
            } else if (findWay(i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else { // 如果当前这个点是1、2或者3，则都返回false，说明当前这个点不能走或已经走过
            return false;
        }
    }

    /**
     * 显示迷宫地图
     */
    public void showMap() {
        for (int[] row : map) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
        System.out.printf("走迷宫递归了%d次", count);
    }
}
