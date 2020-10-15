package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhan
 * @Date 2020/10/15 21:50
 * 顺序存储二叉树demo
 */
@SpringBootTest
public class ArrBinaryTreeDemo {

    @Test
    void demo() {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历----------");
        arrBinaryTree.preOrder();
        System.out.println();
        System.out.println("中序遍历----------");
        arrBinaryTree.inOrder();
        System.out.println();
        System.out.println("后序遍历----------");
        arrBinaryTree.postOrder();
    }
}
