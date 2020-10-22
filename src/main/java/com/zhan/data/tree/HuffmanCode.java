package com.zhan.data.tree;

import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhanzhan
 * @Date 2020/10/22 20:19
 * 赫夫曼编码(压缩数据)
 */
public class HuffmanCode {

    /**
     * 生成一个赫夫曼树
     * @param content 给定的字符串
     * @return 赫夫曼树
     */
    public Node creatHuffmanTree(String content){
        List<Node> nodes = getNodes(content);
        while (nodes.size() > 1){
            // 升序排序
            Collections.sort(nodes);

            // 取出根节点权值最小的两颗二叉树
            // 1、首先取出权值最小的节点(下标为0的元素构成的二叉树)
            Node leftNode = nodes.get(0);
            // 2、然后取出权值第二小的节点(下标为1的元素构成的二叉树)
            Node rightNode = nodes.get(1);
            // 3、构建一颗新的二叉树
            Node parent = new Node(leftNode.weight + rightNode.weight,null);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4、从集合中删除处理过的二叉树的元素
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5、将新构建的parent二叉树的根节点加入到 集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 前序遍历
     * @param root 根节点
     */
    public void preOrder(Node root){
        if (root == null){
            return;
        }
        root.preOrder();
    }

    /**
     * <p>将给定的 String 转为 node集合</p>
     * <p>node 中包含该字符串的每个字符以及其出现的次数</p>
     * @param content 给定的字符串
     * @return
     */
    private List<Node> getNodes(String content){
        List<Node> nodes = new ArrayList<>();
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        Map<Byte,Integer> map = new HashMap<>();
        for (byte b : bytes){
            map.put(b, map.getOrDefault(b,0) + 1);
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getValue(),entry.getKey()));
        }
        return nodes;
    }

    @Data
    static class Node implements Comparable<Node>{
        private int weight; // 节点的权值
        private Byte data; // 节点保存的数据
        private Node left; // 左子节点
        private Node right; // 右子节点

        public Node(int weight, Byte data) {
            this.weight = weight;
            this.data = data;
        }

        /**
         * 前序遍历
         */
        public void preOrder(){
            System.out.println(this);
            if (left != null){
                left.preOrder();
            }
            if (right != null){
                right.preOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", data=" + data +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            // 从小到大排序
            return weight - o.weight;
        }
    }
}
