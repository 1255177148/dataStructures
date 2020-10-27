package com.zhan.data.tree;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/10/27 21:06
 * 二叉排序树
 */
@Data
public class BinarySortTree {

    private Node root;

    /**
     * <p>添加一个节点到二叉排序树种</p>
     * <p>保证节点的左子节点小于自己，节点的右子节点大于自己</p>
     * @param node 要添加的节点
     */
    public void add(Node node){
        if (root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    public void inOrder(){
        if (root == null){
            System.out.println("当前二叉排序树为空");
            return;
        }
        root.inOrder();
    }

    @Data
    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        /**
         * <p>添加一个节点到二叉排序树种</p>
         * <p>保证节点的左子节点小于自己，节点的右子节点大于自己</p>
         * @param node 要添加的节点
         */
        public void add(Node node){
            if (node == null){
                return;
            }
            Node temp = this;
            // 这里是用 while 循环替代递归，不断向子树递归，直到找到要插入的位置
            while (true){
                // 比较传入的节点和当前节点的值大小
                if (node.value < temp.value){ // 如果传入的节点的值小于当前节点
                    // 如果当前节点左子节点为null
                    if (temp.left == null){
                        // 将节点添加到左子节点上
                        temp.left = node;
                        break;
                    } else { // 如果当前节点左子节点不为null,则继续向下查询，获取要插入的位置
                        temp = temp.left; // 继续向左子节点递归查找
                    }
                } else { // 如果传入的节点的值大于等于当前节点
                    // 如果当前节点右子节点为null
                    if (temp.right == null){
                        // 将节点添加到右子节点上
                        temp.right = node;
                        break;
                    } else { // 如果当前节点右子节点不为null,则继续向下查询，获取要插入的位置
                        temp = temp.right; // 继续向右子节点递归查找
                    }
                }
            }
        }

        /**
         * 中序遍历
         */
        public void inOrder(){
            if (this.left != null){
                left.inOrder();
            }
            System.out.println(this);
            if (this.right != null){
                right.inOrder();
            }
        }
    }
}
