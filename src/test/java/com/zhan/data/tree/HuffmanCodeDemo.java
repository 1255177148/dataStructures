package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Zhanzhan
 * @Date 2020/10/22 22:18
 * 赫夫曼编码(数据压缩)
 */
@SpringBootTest
public class HuffmanCodeDemo {

    /**
     * 获取赫夫曼树
     */
    @Test
    void getHuffmanTree() {
        String content = "i like like like java do you like a java";
        HuffmanCode huffmanCode = new HuffmanCode();
        HuffmanCode.Node node = huffmanCode.creatHuffmanTree(content);
        node.preOrder();
    }
}
