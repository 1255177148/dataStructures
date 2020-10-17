package com.zhan.data.tree;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/10/16 21:26
 * 线索化二叉树
 */
@Data
public class ThreadBinaryTree {
    private Node root;
    private Node pre;

    /**
     * 前序线索化遍历二叉树
     */
    public void preThreadList(){
        Node node = root;
        while (node != null){
            // 输出当前节点
            System.out.println(node.toString());

            while (node.getLeftType() == 0){
                node = node.getLeft();
                System.out.println(node.toString());
            }
            if (node.getRight() == null){
                break;
            }
            if (node.getRightType() == 1){
                node = node.getRight();
            }
        }
    }

    /**
     * 中序线索化遍历二叉树
     */
    public void threadList(){
        Node node = root;
        while (node != null){
            // 循环找到leftType == 1 的节点
            // 后面随着遍历，node 会变化
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            // 打印当前节点
            System.out.println(node.toString());

            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node.toString());
            }

            // 替换当前遍历的节点
            node = node.getRight();
        }
    }

    /**
     * <p>重载 preThreadNodes()</p>
     * <p>对二叉树进行前序线索化</p>
     */
    public void preThreadNodes(){
        preThreadNodes(root);
    }

    /**
     * <p>重载下threadNodes()</p>
     * <p>对二叉树进行中序线索化</p>
     */
    public void threadNodes(){
        threadNodes(root);
    }

    /**
     * 对二叉树进行前序线索化
     * @param node 当前需要线索化的节点
     */
    public void preThreadNodes(Node node){
        if (node == null){
            return;
        }
        // 线索化当前节点
        if (node.left == null){
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针类型
            node.setLeftType(1);
        }
        // 处理后继节点
        if (pre != null && pre.right == null && pre.left != node){
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        // 线索化左子树
        if(node.getLeftType() == 0){
            preThreadNodes(node.getLeft());
        }

        // 线索化右子树
        preThreadNodes(node.getRight());
    }

    /**
     * 对二叉树进行中序线索化
     * @param node 当前需要线索化的节点
     */
    public void threadNodes(Node node){
        // 如果 node == null,不能线索化
        if (node == null){
            return;
        }

        // 先线索化左子树
        threadNodes(node.getLeft());

        // 线索化当前节点
        if (node.left == null){
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针类型
            node.setLeftType(1);
        }

        // 处理后继节点
        if (pre != null && pre.right == null){
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightType(1);
        }

        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        // 线索化右子树
        threadNodes(node.getRight());
    }

    @Data
    static class Node {
        private int key;
        private String value;
        private Node left;
        private Node right;
        private int leftType; // 如果为0，则表示left指向的是左子节点；为1，则表示指向的是前驱节点
        private int rightType; // 如果为0，则表示right指向的是左子节点；为1，则表示指向的是后继节点

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
    }
}
