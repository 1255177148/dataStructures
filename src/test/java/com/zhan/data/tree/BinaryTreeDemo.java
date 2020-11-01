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
        BinaryTree binaryTree = initTree();

        System.out.println("前序遍历------------");
        binaryTree.preOrder();

        System.out.println("中序遍历------------");
        binaryTree.inOrder();

        System.out.println("后序遍历------------");
        binaryTree.postOrder();

        System.out.println("前序查找------------");
        BinaryTree.Node preNode = binaryTree.preOrderSearch(5);
        if (preNode != null){
            System.out.printf("找到了，数据为 key=%d, value=%s\n", preNode.getKey(), preNode.getValue());
        } else {
            System.out.printf("没找到 key=%d的数据\n", 5);
        }

        System.out.println("中序查找------------");
        BinaryTree.Node inNode = binaryTree.inOrderSearch(5);
        if (inNode != null){
            System.out.printf("找到了，数据为 key=%d, value=%s\n", inNode.getKey(), inNode.getValue());
        } else {
            System.out.printf("没找到 key=%d的数据\n", 5);
        }

        System.out.println("后序查找------------");
        BinaryTree.Node postNode = binaryTree.postOrderSearch(5);
        if (postNode != null){
            System.out.printf("找到了，数据为 key=%d, value=%s\n", postNode.getKey(), postNode.getValue());
        } else {
            System.out.printf("没找到 key=%d的数据\n", 5);
        }
    }

    @Test
    void deleteDemo() {
        BinaryTree binaryTree = initTree();
        System.out.println("删除前的树为:");
        binaryTree.preOrder();
        binaryTree.delNode(1);
        System.out.println("删除后的树为:");
        binaryTree.preOrder();
    }

    /**
     * 初始化一个树
     * @return
     */
    private BinaryTree initTree(){
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
        return binaryTree;
    }
}
