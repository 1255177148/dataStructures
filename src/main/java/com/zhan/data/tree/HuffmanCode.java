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
@Data
public class HuffmanCode {

    public HuffmanCode() {
        huffmanCodes = new HashMap<>();
    }

    private Map<Byte, String> huffmanCodes;

    /**
     * 生成一个赫夫曼树
     * @param content 给定的字符串
     * @return 赫夫曼树
     */
    public Node createHuffmanTree(String content){
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
     * 得到传入的node节点的所有叶子节点的赫夫曼编码，并放入集合中
     * @param node 传入的节点
     * @return 赫夫曼编码集合
     */
    public Map<Byte, String> getCodes(Node node){
        getCodes(node, "", new StringBuilder());
        return huffmanCodes;
    }

    /**
     * 得到传入的node节点的所有叶子节点的赫夫曼编码，并放入集合中
     * @param node 传入的节点
     * @param code 赫夫曼树的路径，左子节点为0；右子节点为1
     * @param sb 用来拼接路径，形成编码
     */
    public void getCodes(Node node, String code, StringBuilder sb){
        if (node == null){
            return;
        }
        StringBuilder builder = new StringBuilder(sb);
        // 将 code 拼接到 builder
        builder.append(code);
        // 判断当前节点是否为非叶子节点
        if (node.data == null){ // 非叶子节点
            // 递归处理
            // 向左递归
            getCodes(node.left, "0", builder);
            // 向右递归
            getCodes(node.right, "1", builder);
        } else { // 叶子节点
            huffmanCodes.put(node.data, builder.toString());
        }
    }

    /**
     * 根据给定的数据生成对应的赫夫曼编码数据
     * @param content 给定的数据
     * @return
     */
    public String getHuffmanCoding(String content){
        // 1、获取赫夫曼树
        Node root = createHuffmanTree(content);
        // 2、获取赫夫曼编码集合
        Map<Byte, String> huffmanCodes = getCodes(root);
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()){
                if (b == entry.getKey()){
                    sb.append(entry.getValue());
                }
            }
        }
        return sb.toString();
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
