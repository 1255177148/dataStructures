package com.zhan.data.graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Zhanzhan
 * @Date 2020/11/7 10:37
 * 数据结构--图
 * 使用邻接矩阵表示图
 */
@Data
public class GraphByMatrix {

    private List<String> vertexList; // 存储顶点集合
    private int[][] edges; // 存储对应的邻接矩阵
    private int edgesNum; // 表示边的数目
    private boolean[] visited; // 定义一个boolean数组,记录某个顶点是否被访问

    /**
     * 构造方法,传入顶点的个数
     * @param n 顶点的个数
     */
    public GraphByMatrix(int n) {
        // 初始化矩阵和顶点集合
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        visited = new boolean[n];
    }

    /**
     * <p>深度优先遍历</p>
     * <p>对每个顶点都进行深度优先遍历</p>
     */
    public void dfs(){
        int length = vertexList.size();
        for (int i = 0; i < length;i++){
            if (!visited[i]){
                dfs(i);
            }
        }
    }

    /**
     * <p>对下标为 i 的顶点进行深度遍历,思路:</p>
     * <blockquote><pre>
     *     1、以给定的下标为起点,选择一个临近顶点,然后一路递归遍历下去;
     *     2、如果在递归中,找不到当前顶点的临近顶点,那么返回到上一顶点,选择另一个临近顶点继续递归遍历
     * </pre></blockquote>
     * @param i 给定的下标
     */
    private void dfs(int i){
        // 首先输出访问的当前顶点
        System.out.print(getVertexValueByIndex(i) + "->");
        // 将当前顶点设置为已访问
        visited[i] = true;
        // 查找 i 的邻接点 下标
        int n = getNeighbor(i);
        while (n != -1){
            dfs(n);
            n = getNeighbor(i);
        }
    }

    /**
     * 得到一个没有被访问过的邻接顶点的下标
     * @param index 给定 顶点的下标
     * @return 如果存在就返回对应的下标,否则返回 -1
     */
    private int getNeighbor(int index){
        int length = vertexList.size();
        for (int j = 0;j < length; j++){
            if (edges[index][j] > 0 && !visited[j]){
                return j;
            }
        }
        return -1;
    }

    /**
     * 添加一个顶点
     * @param vertex 要添加的顶点
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 得到图中顶点的数目
     * @return 顶点的数目
     */
    public int getVertexNum(){
        return vertexList.size();
    }

    /**
     * 得到边的数目
     * @return 边的数目
     */
    public int getEdgesNum(){
        return edgesNum;
    }

    /**
     * 返回下标为 index 的顶点对应的数据
     * @param index 顶点的下标
     * @return 下标为 index 的顶点对应的数据
     */
    public String getVertexValueByIndex(int index){
        return vertexList.get(index);
    }

    /**
     * <p>添加边,即第一个顶点和第二个顶点之间的联系,</p>
     * <p>因为是用邻接矩阵来表示,所以这里使用二维数组的 行 和 列 来表示两个顶点,</p>
     * <p>edges[1][1] 表示行的下标为1, 列的下标为1 的两个顶点的边 的数据</p>
     * @param v1 表示二维数组中行的下标
     * @param v2 表示二维数组中列的下标
     * @param weight 表示对应的边的权值, 这里约定权值为0 就表示 这两个顶点间没有边相连
     */
    public void insertEdge(int v1, int v2, int weight){
        // 由于这里是模拟的无向图, 所以两个顶点间互相都有到对方的边, 也就是边是双向的, 所以 二维数组要设置两次的权值
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgesNum++;
    }

    /**
     * 得到 二维数组中 对应两个顶点的边的权值
     * @param v1 二维数组中行的下标
     * @param v2 二维数组中列的下标
     * @return 二维数组中 对应两个顶点的边的权值
     */
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for (int[] arr : edges){
            System.out.println(Arrays.toString(arr));
        }
    }
}
