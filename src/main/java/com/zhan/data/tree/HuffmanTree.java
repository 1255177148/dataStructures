package com.zhan.data.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Zhanzhan
 * @Date 2020/10/19 21:20
 * 赫夫曼树，树的带权路径最小的就是赫夫曼树
 */
public class HuffmanTree {

    /**
     * <p>创建赫夫曼树，思路:</p>
     * <p>1、将数据升序排列，数组中每个元素视为一棵树，一颗只有根节点的树</p>
     * <p>2、权值最小的两棵树，构建为一棵树，此时，新生成的树的根节点就为原两个节点的权值之和，原来的节点就不在原始数组中</p>
     * <p>3、然后将新生成的树的根节点放入数组中，重新排序，重复 1 和 2 步骤，直到元素中只有一个节点为止</p>
     *
     * @param arr 要创建赫夫曼树的 数组
     */
    public Node creatHuffmanTree(int[] arr) {
        // 1、遍历arr数组
        // 2、将arr的每个元素构建成一个Node
        // 3、将Node 放入ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            // 升序排序
            Collections.sort(nodes);

            // 取出根节点权值最小的两颗二叉树
            // 1、首先取出权值最小的节点(下标为0的元素构成的二叉树)
            Node leftNode = nodes.get(0);
            // 2、然后取出权值第二小的节点(下标为1的元素构成的二叉树)
            Node rightNode = nodes.get(1);
            // 3、构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
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
     *
     * @param root 根节点
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        root.preOrder();
    }

    /**
     * 创建节点类
     * 为了让 Node 对象持续排序
     * 可以使用Collections 集合排序
     * 让 Node 实现Comparable接口
     */
    @Data
    static class Node implements Comparable<Node> {
        private int value; // 节点的权值
        private Node left; // 左子节点
        private Node right; // 右子节点

        public Node(int value) {
            this.value = value;
        }

        /**
         * 前序遍历
         */
        public void preOrder() {
            System.out.print(this.value + "\t");
            if (this.left != null) {
                left.preOrder();
            }
            if (this.right != null) {
                right.preOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            // 从小到大进行排序
            return value - o.value;
        }
    }
}
