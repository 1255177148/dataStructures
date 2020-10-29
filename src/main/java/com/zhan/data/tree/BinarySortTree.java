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

    /**
     * 中序遍历
     */
    public void inOrder(){
        if (root == null){
            System.out.println("当前二叉排序树为空");
            return;
        }
        root.inOrder();
    }

    /**
     * 查找要删除的节点
     * @param value 要删除节点的值
     * @return 要删除的节点
     */
    public Node search(int value){
        if (root == null){
            return null;
        }
        return root.search(value);
    }

    /**
     * 查找要删除的节点的父节点
     * @param value 要删除的节点的值
     * @return 要删除节点的父节点
     */
    public Node searchParent(int value){
        if (root == null){
            return null;
        }
        return root.searchParent(value);
    }

    /**
     * 删除指定的节点
     * @param value 要删除的节点的值
     */
    public void remove(int value){

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

        /**
         * 根据指定的值查找节点
         * @param value 要查找的值
         * @return 对应的节点
         */
        public Node search(int value){
            Node temp = this;
            while (true){
                if (temp == null){
                    return null;
                }
                // 找到就返回该节点
                if (temp.value == value){
                    return temp;
                }
                if (value < temp.value){ // 如果要找的值小于当前节点的值
                    // 向左子节点继续查找
                    temp = temp.left;
                } else { // 如果要找的值大于当前节点的值
                    // 向右子节点继续查找
                    temp = temp.right;
                }
            }
        }

        /**
         * 查找要删除节点的父节点
         * @param value 要删除的节点的值
         * @return 要删除节点的父节点
         */
        public Node searchParent(int value){
            Node temp = this;
            while (true){
                // 如果当前节点就是要删除的节点的父节点
                if ((temp.left != null && temp.left.value == value) ||
                        (temp.right != null && temp.right.value == value)){
                    return temp;
                } else {
                    if (value < temp.value && temp.left != null){ // 如果目标值小于当前节点，并且当前节点的左子节点不为空
                        temp = temp.left; // 向左子节点继续查找
                    } else if (value >= temp.value && temp.right != null){ // 如果目标值大于等于当前节点，并且当前节点的右子节点不为空
                        temp = temp.right; // 向右子节点继续查找
                    } else {
                        return null;
                    }
                }
            }
        }
    }
}
