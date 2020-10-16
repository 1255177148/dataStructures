package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/10/16 22:09
 * 线索化二叉树demo
 */
@SpringBootTest
public class ThreadBinaryTreeDemo {
    @Test
    void demo() {
        ThreadBinaryTree.Node root = new ThreadBinaryTree.Node(1, "tom");
        ThreadBinaryTree.Node node2 = new ThreadBinaryTree.Node(3,"jack");
        ThreadBinaryTree.Node node3 = new ThreadBinaryTree.Node(6,"smith");
        ThreadBinaryTree.Node node4 = new ThreadBinaryTree.Node(8,"mary");
        ThreadBinaryTree.Node node5 = new ThreadBinaryTree.Node(10,"king");
        ThreadBinaryTree.Node node6 = new ThreadBinaryTree.Node(14,"dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);

        // 已key = 10 的节点为测试对象，查看是否已线索化
        ThreadBinaryTree.Node leftNode1 = node5.getLeft();
        ThreadBinaryTree.Node rightNode1 = node5.getRight();

        System.out.println("线索化二叉树之前-------------");
        System.out.println("key为10的节点的前驱节点是：" + leftNode1);
        System.out.println("key为10的后继节点为：" + rightNode1);

        System.out.println("线索化二叉树之后-------------");
        threadBinaryTree.threadNodes();
        ThreadBinaryTree.Node leftNode2 = node5.getLeft();
        ThreadBinaryTree.Node rightNode2 = node5.getRight();
        System.out.println("key为10的节点的前驱节点是：" + leftNode2.toString());
        System.out.println("key为10的后继节点为：" + rightNode2.toString());

        System.out.println("使用线索化的方式遍历二叉树，遍历顺序保持线索化是的顺序-------------");
        threadBinaryTree.threadList();
    }
}
