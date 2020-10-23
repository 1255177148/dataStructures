package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

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
        HuffmanCode.Node node = huffmanCode.createHuffmanTree(content);
        node.preOrder();
    }

    /**
     * 获取赫夫曼编码集合，即编码对照表
     */
    @Test
    void getHuffmanCodeMap() {
        String content = "i like like like java do you like a java";
        HuffmanCode huffmanCode = new HuffmanCode();
        HuffmanCode.Node node = huffmanCode.createHuffmanTree(content);
        huffmanCode.getCodes(node, "", new StringBuilder());
        System.out.println("赫夫曼编码为:" + huffmanCode.getHuffmanCodes());
        Map<Byte, String> map = huffmanCode.getCodes(node);
        System.out.println("赫夫曼编码为:" + map);
    }

    /**
     * 根据给定的数据，生成对应的赫夫曼编码
     */
    @Test
    void getHuffmanCoding() {
        String content = "i like like like java do you like a java";
        System.out.println("编码前的长度为:" + content.length());
        HuffmanCode huffmanCode = new HuffmanCode();
        String coding = huffmanCode.getHuffmanCoding(content);
        System.out.println("对应的赫夫曼编码数据为:" + coding);
        System.out.println("编码后的数据长度为:" + coding.length());
    }
}
