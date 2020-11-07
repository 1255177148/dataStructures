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
     * 创建一个图
     */
    @Test
    void demoForCreat() {
        int n = 5; // 顶点的个数
        String[] vertexValue = {"A","B","C","D","E"};
        // 创建 图
        GraphByMatrix graph = new GraphByMatrix(n);
        // 循环添加顶点
        for (String value : vertexValue){
            graph.insertVertex(value);
        }
        // 添加边
        // A-B A-C B-C B-D B-E 互相连接
        graph.insertEdge(0,1,1);// A-B
        graph.insertEdge(0,2,1);// A-C
        graph.insertEdge(1,2,1);// B-C
//        graph.insertEdge(1,3,1);// B-D
//        graph.insertEdge(1,4,1);// B-E
        graph.insertEdge(3,4,1);// D-E

        // 显示邻接矩阵
        graph.showGraph();

        System.out.println("深度优先遍历");
        graph.dfs();
    }
}
