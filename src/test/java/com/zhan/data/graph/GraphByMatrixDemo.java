package com.zhan.data.graph;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/11/7 11:01
 * 数据结构--图 的demo, 使用邻接矩阵表示
 */
@SpringBootTest
public class GraphByMatrixDemo {

    /**
     * 创建一个图,并测试深度优先遍历
     */
    @Test
    void demoForDfs() {
        int n = 8; // 顶点的个数
        String[] vertexValue = {"1","2","3","4","5","6","7","8"};
        // 创建 图
        GraphByMatrix graph = new GraphByMatrix(n);
        // 循环添加顶点
        for (String value : vertexValue){
            graph.insertVertex(value);
        }
        // 添加边
        graph.insertEdge(0,1,1);// 1-2
        graph.insertEdge(0,2,1);// 1-3
        graph.insertEdge(1,3,1);// 2-4
        graph.insertEdge(1,4,1);// 2-5
        graph.insertEdge(2,5,1);// 3-6
        graph.insertEdge(2,6,1);// 3-7
        graph.insertEdge(5,6,1);// 6-7
        graph.insertEdge(3,7,1);// 4-8
        graph.insertEdge(4,7,1);// 5-8

        // 显示邻接矩阵
        graph.showGraph();

        System.out.println("深度优先遍历");
        graph.dfs();
    }

    /**
     * 创建一个图，并测试广度优先遍历
     */
    @Test
    void demoForBfs() {
        int n = 8; // 顶点的个数
        String[] vertexValue = {"1","2","3","4","5","6","7","8"};
        // 创建 图
        GraphByMatrix graph = new GraphByMatrix(n);
        // 循环添加顶点
        for (String value : vertexValue){
            graph.insertVertex(value);
        }
        // 添加边
        graph.insertEdge(0,1,1);// 1-2
        graph.insertEdge(0,2,1);// 1-3
        graph.insertEdge(1,3,1);// 2-4
        graph.insertEdge(1,4,1);// 2-5
        graph.insertEdge(2,5,1);// 3-6
        graph.insertEdge(2,6,1);// 3-7
        graph.insertEdge(5,6,1);// 6-7
        graph.insertEdge(3,7,1);// 4-8
        graph.insertEdge(4,7,1);// 5-8

        // 显示邻接矩阵
        graph.showGraph();

        System.out.println("广度优先遍历");
        graph.bfs();
    }
}
