package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/10/11 16:12
 * 二叉树demo
 */
@SpringBootTest
public class BinaryTreeDemo {

    /**
     * 测试前序遍历、中序遍历和后序遍历
     */
    @Test
    void order() {
        BinaryTree.Node root = new BinaryTree.Node(1, "宋江");
        BinaryTree.Node node2 = new BinaryTree.Node(2, "吴用");
        BinaryTree.Node node3 = new BinaryTree.Node(3, "卢俊义");
        BinaryTree.Node node4 = new BinaryTree.Node(4, "林冲");
        BinaryTree.Node node5 = new BinaryTree.Node(5, "关胜");
        BinaryTree binaryTree = new BinaryTree();

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        System.out.println("前序遍历------------");
        binaryTree.preOrder();

        System.out.println("中序遍历------------");
        binaryTree.inOrder();

        System.out.println("后序遍历------------");
        binaryTree.postOrder();
    }
}
