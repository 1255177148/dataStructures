package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhanzhan
 * @Date 2020/10/19 21:52
 * 赫夫曼树demo
 */
@SpringBootTest
public class HuffmanTreeDemo {
    @Test
    void demo() {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        HuffmanTree.Node root = huffmanTree.creatHuffmanTree(arr);
        huffmanTree.preOrder(root);
    }
}
