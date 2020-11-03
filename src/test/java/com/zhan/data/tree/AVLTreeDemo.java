package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/11/3 20:48
 * 平衡二叉树demo
 */
@SpringBootTest
public class AVLTreeDemo {

    @Test
    void demoForHeight() {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new AVLTree.Node(i, String.valueOf(i)));
        }
        System.out.println("中序遍历--------");
        avlTree.inOrder();

        System.out.println("树的高度=" + avlTree.getRoot().height());
        System.out.println("树的左子树的高度=" + avlTree.getRoot().getLeft().height());
        System.out.println("树的右子树的高度=" + avlTree.getRoot().getRight().height());
    }
}
