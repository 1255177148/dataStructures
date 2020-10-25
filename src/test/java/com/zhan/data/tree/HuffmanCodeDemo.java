package com.zhan.data.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
        HuffmanCode.Node node = huffmanCode.createHuffmanTree(content.getBytes(StandardCharsets.UTF_8));
        node.preOrder();
    }

    /**
     * 获取赫夫曼编码集合，即编码对照表
     */
    @Test
    void getHuffmanCodeMap() {
        String content = "i like like like java do you like a java";
        HuffmanCode huffmanCode = new HuffmanCode();
        HuffmanCode.Node node = huffmanCode.createHuffmanTree(content.getBytes(StandardCharsets.UTF_8));
        huffmanCode.getCodes(node, "", new StringBuilder());
        System.out.println("赫夫曼编码为:" + huffmanCode.getHuffmanCodes());
        Map<Byte, String> map = huffmanCode.getCodes(node);
        System.out.println("赫夫曼编码为:" + map);
    }

    /**
     * 根据给定的数据，生成对应的赫夫曼编码，并且将编码压缩后的数据解码出来
     */
    @Test
    void getHuffmanCoding() {
        String content = "我喜欢Java$/?<>,.!@#%^&*()-=";
        System.out.println("编码前的数据为:" + content);
        System.out.println("编码前的长度为:" + content.getBytes(StandardCharsets.UTF_8).length);
        HuffmanCode huffmanCode = new HuffmanCode();
        HuffmanCode.Zip zip = huffmanCode.getHuffmanZip(content.getBytes(StandardCharsets.UTF_8));
        System.out.println("对应的赫夫曼编码数据为:" + Arrays.toString(zip.getData()));
        System.out.println("编码后的长度为:" + zip.getData().length);
        byte[] decode = huffmanCode.decode(huffmanCode.getHuffmanCodes(), zip.getData(), zip.getLength());
        System.out.println("赫夫曼解码后的数据为:" + new String(decode, StandardCharsets.UTF_8));
    }

    /**
     * 压缩文件
     */
    @Test
    void zipFile() throws Exception {
        String targetFile = "F:\\1.txt";
        String toFile = "F:\\1.zip";
        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.zipFile(targetFile, toFile);
    }

    /**
     * 解压文件
     */
    @Test
    void unZipFile() throws Exception {
        String targetFile = "F:\\1.zip";
        String toFile = "F:\\2.txt";
        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.unZipFile(targetFile, toFile);
    }
}
