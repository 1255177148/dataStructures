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

    /**
     * 添加完节点后，对整个红黑树进行调整以满足红黑树的规则
     * @param node
     */
    public void fixAfterInsert(Node node){

    }

    /**
     * <p>红黑树的左旋，思路:</p>
     * <pre>
     *     1、看当前节点是否是根节点
     *        1.1、如果是根节点,则将当前节点的右子节点设置为根节点
     *        1.2、如果不是根节点
     *          (1)、如果父节点的左子节点是当前节点，则将当前节点的右子节点设置为父节点的左子节点
     *          (2)、如果父节点的右子节点是当前节点，则将当前节点的右子节点设置为父节点的右子节点
     *     2、将当前节点的右子节点设置为当前节点的父节点
     *     3、将当前节点的右子节点的左子节点设置为当前节点的右子节点
     *     4、将当前节点设置为其右子节点的左子节点
     * </pre>
     * @param node
     */
    private void leftRotate(Node node){
        Node right = node.getRight();
        Node parent = node.getParent();
        if (parent == null){ // 如果当前节点是根节点
            right.setParent(null);
            root = right;
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node){
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if (right.getLeft() != null){
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /**
     * <p>红黑树的右旋，思路：</p>
     * <pre>
     *     1、看当前节点是否是根节点
     *        1.1、如果是根节点，则将当前节点的左子节点设置为根节点
     *        1.2、如果不是根节点
     *          (1)、如果当前节点是父节点的左子节点，则将当前节点的左子节点设置为父节点的左子节点
     *          (2)、如果当前节点是父节点的右子节点，则将当前节点的左子节点设置为父节点的右子节点
     *     2、将当前节点的左子节点设置为当前节点的父节点
     *     3、将当前节点的左子节点的右子节点设置为当前节点的左子节点
     *     4、将当前节点设置为其左子节点的右子节点
     * </pre>
     * @param node
     */
    private void rightRotate(Node node){
        Node left = node.getLeft();
        Node parent = node.getParent();
        if (parent == null){
            left.setParent(null);
            root = left;
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node){
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null){
            left.getRight().setParent(node);
        }
        left.setRight(node);
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
