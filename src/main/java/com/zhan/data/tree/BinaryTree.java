package com.zhan.data.tree;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/10/11 15:21
 * 二叉树
 */
@Data
public class BinaryTree {

    private Node root;

    /**
     * <p>前序遍历</p>
     * <p>1、先输出父节点</p>
     * <p>2、然后向左递归遍历输出</p>
     * <p>3、最后向右递归遍历输出</p>
     */
    public void preOrder(){
        if (root != null){
            root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * <p>中序遍历</p>
     * <p>1、先向左递归遍历输出</p>
     * <p>2、然后输入父节点</p>
     * <p>3、最后向右递归遍历输出</p>
     */
    public void inOrder(){
        if (root != null){
            root.inOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * <p>后序遍历</p>
     * <p>1、先向左递归遍历输出</p>
     * <p>2、最后向右递归遍历输出</p>
     * <p>3、然后输入父节点</p>
     */
    public void postOrder(){
        if (root != null){
            root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    @Data
    static class Node{
        private int key;
        private String value;
        private Node left;
        private Node right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }

        /**
         * <p>前序遍历</p>
         * <p>1、先输出父节点</p>
         * <p>2、然后向左递归遍历输出</p>
         * <p>3、最后向右递归遍历输出</p>
         */
        public void preOrder(){
            System.out.println(this); // 先输出父节点
            // 递归向左子树遍历
            if (left != null){
                left.preOrder();
            }
            // 递归向右子树遍历
            if (right != null){
                right.preOrder();
            }
        }

        /**
         * <p>中序遍历</p>
         * <p>1、先向左递归遍历输出</p>
         * <p>2、然后输入父节点</p>
         * <p>3、最后向右递归遍历输出</p>
         */
        public void inOrder(){
            // 递归向左子树遍历
            if (left != null){
                left.inOrder();
            }
            System.out.println(this); // 输出父节点
            // 递归向右子树遍历
            if (right != null){
                right.inOrder();
            }
        }

        /**
         * <p>后序遍历</p>
         * <p>1、先向左递归遍历输出</p>
         * <p>2、最后向右递归遍历输出</p>
         * <p>3、然后输入父节点</p>
         */
        public void postOrder(){
            // 递归向左子树遍历
            if (left != null){
                left.postOrder();
            }

            // 递归向右子树遍历
            if (right != null){
                right.postOrder();
            }

            System.out.println(this); // 输出父节点
        }
    }
}
