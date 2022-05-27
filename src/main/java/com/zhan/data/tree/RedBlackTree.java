package com.zhan.data.tree;

import lombok.Data;

/**
 * <p>红黑树</p>
 * <pre>
 *     1、节点是红色或黑色;
 *     2、根节点是黑色;
 *     3、每个叶子节点都是黑色的空节点(NIL节点);
 *     4、每个红色节点的两个子节点都是黑色(从每个叶子节点到根节点的路径上不可能有两个连续的红色节点);
 *     5、从任一节点到其每个叶子的所有路径都包含相同数据的黑色节点.
 * </pre>
 * @Author elvis
 * @Date 2022/5/27 9:55
 */
@Data
public class RedBlackTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 中序遍历
     */
    public void inOrder(){
        if (root == null){
            System.out.println("当前红黑树为空");
            return;
        }
        root.inOrder();
    }

    @Data
    static class Node{
        private int key;
        private String value;
        private boolean isBlack;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.isBlack = false;// 新节点默认是红色
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }

        /**
         * 中序遍历，左-父-右 的顺序遍历
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
