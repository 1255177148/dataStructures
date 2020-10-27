package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/10/27 21:27
 * 二叉排序树demo
 */
@SpringBootTest
public class BinarySortTreeDemo {
    @Test
    void demoForAdd() {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加节点到二叉树
        for (int value : arr) {
            binarySortTree.add(new BinarySortTree.Node(value));
        }
        System.out.println("创建的二叉排序树的中序遍历为:");
        binarySortTree.inOrder();
    }
}
