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
     * <p>添加完节点后，对整个红黑树进行调整以满足红黑树的规则</p>
     * <pre>
     *     1、如果父亲节点和叔叔节点都是红色的，则将父亲和叔叔变为黑色，祖父变为红色，继续向上以祖父开始做调整
     *     2、如果没有叔叔节点或者叔叔节点是黑色的，父亲节点是红色的
     *        2.1、如果父亲在祖父的左侧
     *          (1)、如果当前节点在父节点的右侧，对父节点进行左旋，这时，当前节点和父节点需要互换，因为旋转后，当前节点和父节点的位置会互换
     *          (2)、将父节点设置为黑色，祖父设置为红色
     *          (3)、对祖父节点进行右旋
     *        2.2、如果父亲在祖父的右侧
     *          (1)、如果当前节点在父节点的左侧，对父节点进行右旋，这是，当前节点和父节点需要互换
     *          (2)、将父节点设置为黑色，祖父设置为红色
     *          (3)、对祖父节点进行左旋
     *     3、将根节点设置为黑色
     *
     * </pre>
     * @param node
     */
    public void balanceInsert(Node node){
        Node father, gFather;
        // 父节点是红色的
        while ((father = node.getParent()) != null && !father.isBlack){
            gFather = father.getParent();
            if (gFather.getLeft() == father){ // 父节点在祖父的左侧
                Node uncle = gFather.getRight();
                if (uncle != null && !uncle.isBlack){
                    setBlack(father);
                    setBlack(uncle);
                    setRed(gFather);
                    node = gFather;
                    continue;
                }
                if (node == father.getRight()){
                    leftRotate(father);// 对父节点进行左旋
                    //todo 这里的对象互换需要验证，我觉得这里没有互换，需要进行深拷贝互换
                    Node temp = node;
                    node = father;
                    father = temp;
                }
            }
        }
    }

    private void exchange(Node node1, Node node2){

    }

    private void setBlack(Node node){
        node.setBlack(true);
    }

    private void setRed(Node node){
        node.setBlack(false);
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
