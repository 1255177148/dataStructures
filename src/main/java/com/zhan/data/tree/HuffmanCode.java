package com.zhan.data.tree;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhanzhan
 * @Date 2020/10/22 20:19
 * 赫夫曼编码(压缩数据)
 */
@Data
public class HuffmanCode {

    public HuffmanCode() {
        huffmanCodes = new HashMap<>();
    }

    private Map<Byte, String> huffmanCodes;

    /**
     * 生成一个赫夫曼树
     *
     * @param content 给定的字符串
     * @return 赫夫曼树
     */
    public Node createHuffmanTree(String content) {
        List<Node> nodes = getNodes(content);
        while (nodes.size() > 1) {
            // 升序排序
            Collections.sort(nodes);

            // 取出根节点权值最小的两颗二叉树
            // 1、首先取出权值最小的节点(下标为0的元素构成的二叉树)
            Node leftNode = nodes.get(0);
            // 2、然后取出权值第二小的节点(下标为1的元素构成的二叉树)
            Node rightNode = nodes.get(1);
            // 3、构建一颗新的二叉树
            Node parent = new Node(leftNode.weight + rightNode.weight, null);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4、从集合中删除处理过的二叉树的元素
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5、将新构建的parent二叉树的根节点加入到 集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 得到传入的node节点的所有叶子节点的赫夫曼编码，并放入集合中
     *
     * @param node 传入的节点
     * @return 赫夫曼编码集合
     */
    public Map<Byte, String> getCodes(Node node) {
        getCodes(node, "", new StringBuilder());
        return huffmanCodes;
    }

    /**
     * 得到传入的node节点的所有叶子节点的赫夫曼编码，并放入集合中
     *
     * @param node 传入的节点
     * @param code 赫夫曼树的路径，左子节点为0；右子节点为1
     * @param sb   用来拼接路径，形成编码
     */
    public void getCodes(Node node, String code, StringBuilder sb) {
        if (node == null) {
            return;
        }
        StringBuilder builder = new StringBuilder(sb);
        // 将 code 拼接到 builder
        builder.append(code);
        // 判断当前节点是否为非叶子节点
        if (node.data == null) { // 非叶子节点
            // 递归处理
            // 向左递归
            getCodes(node.left, "0", builder);
            // 向右递归
            getCodes(node.right, "1", builder);
        } else { // 叶子节点
            huffmanCodes.put(node.data, builder.toString());
        }
    }

    /**
     * 根据给定的数据生成对应的赫夫曼编码数据
     *
     * @param content 给定的数据
     * @return
     */
    public Zip getHuffmanZip(String content) {
        Zip zip = new Zip();
        // 1、获取赫夫曼树
        Node root = createHuffmanTree(content);
        // 2、获取赫夫曼编码集合
        Map<Byte, String> huffmanCodes = getCodes(root);
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCodes.get(b));
        }
        System.out.println(sb.toString());
        // 3、将生成的赫夫曼编码的字符串转为byte[],这里生成的编码的，使用字符串来接收的，其实是二进制，所以要以每8位为一个byte，转换为byte[]
        // 统计下要转的byte[] 的长度，因为 是以8位转换为byte，所以要 除以8 取余,
        // 可以一行代码，来得到 len ，int len = (sb.length() + 7) / 8
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        // 创建 byte[] 用来接收压缩后的编码
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; // 记录是第几个byte
        for (int i = 0; i < sb.length(); i += 8) { // 因为每8位对应一个byte,所以步长为 8
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
                zip.setLength(strByte.length());
            } else {
                strByte = sb.substring(i, i + 8);
            }
            // 将 strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        zip.setData(huffmanCodeBytes);
        return zip;
    }

    /**
     * 将赫夫曼编码压缩后的数据，根据给定的赫夫曼编码表，解码还原为原始的数据，以 字节数组(byte[]) 形式返回
     *
     * @param huffmanCodes 对应的赫夫曼编码表
     * @param huffmanData  赫夫曼编码压缩后的数据
     * @param length       给定的压缩数据的最后一位的有效位数
     * @return 解码后的数据
     */
    public byte[] decode(Map<Byte, String> huffmanCodes, @NotNull byte[] huffmanData, int length) {
        // 1、将 byte[] 转换成对应的二进制字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < huffmanData.length; i++) {
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanData.length - 1);
            sb.append(byteToBinaryString(!flag, huffmanData[i], length)); // 如果是最后一个字节，不需要补高位
        }
        System.out.println(sb.toString());
        // 2、把二进制字符串 按指定的赫夫曼编码集合 进行解码
        // 将赫夫曼编码表 huffmanCodes 反向放入一个新的解码表map中，即编码表中的 key 变为新的解码表的value， 编码表的 value 变为解码表的key
        Map<String, Byte> huffmanDecodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            huffmanDecodes.put(entry.getValue(), entry.getKey());
        }
        List<Byte> byteList = new ArrayList<>();
        boolean flag = false; // 标识是否从解码表中找到对应的数据，找到后，就按解码表拿出数据，并从 sb 中截取出来
        int index = 0; // 表示查找的下标
        StringBuilder stringBuilder = new StringBuilder();
        while (sb.length() > 0) {
            if (flag) { // 如果上一次遍历已经从解码表中找到字符，并且截取出去了，就从下标为0开始遍历比对
                index = 0;
            }
            if (index > sb.length() - 1) { // 如果找到最后一位字符，就退出
                break;
            }
            stringBuilder.append(sb.substring(index, index + 1));
            Byte bt = huffmanDecodes.get(stringBuilder.toString());
            if (bt != null) { // 如果从解码表中匹配到
                byteList.add(bt);
                flag = true;
                if (index + 1 > sb.length() - 1) { // 如果找到最后一位字符，就退出
                    break;
                }
                sb.delete(0, index + 1);
                stringBuilder.setLength(0); // 匹配到解码表后，就清空，然后继续下一轮的对比
            } else {
                index++;
                flag = false;
            }
        }
        int size = byteList.size();
        byte[] bytes = new byte[size];
        for (int i = 0; i < size; i++) {
            bytes[i] = byteList.get(i);
        }
        return bytes;
    }

    /**
     * 将一个 byte 转成一个二进制的字符串
     *
     * @param flag   标识是否是最后一个byte数据
     * @param b      传入的需要转二进制的byte
     * @param length 最后一个byte的有效位数
     * @return 该 byte对应的二进制字符串(是按补码返回的)
     */
    private String byteToBinaryString(boolean flag, byte b, int length) {
        int temp = b; // 用 int 接收 b，为何要转int，可以参考下面的main()，因为要补高位
        // 补高位，不足八位的就补到八位
        temp |= 256; // 按为 或256 运算，拿 1 举例，1的二进制为 0000 0001, 则运算式为：1 0000 0000 | 0000 0001 => 1 0000 0001
        String str = Integer.toBinaryString(temp); // 返回的是 temp 对应的二进制的补码
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str.substring(str.length() - length); // 最后一个byte 截取指定的有效位数
        }
    }

    public static void main(String[] args) {
        byte b = 3;
//        b |= 256; // 这里的运算没有任何作用，起不到补高位的作用
        int temp = b; // 所以要转成 int，来进行补高位
        System.out.println(b);
//        temp |= 256;
        System.out.println(temp);
        String str = Integer.toBinaryString(temp);
        System.out.println(str);
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        root.preOrder();
    }

    /**
     * <p>将给定的 String 转为 node集合</p>
     * <p>node 中包含该字符串的每个字符以及其出现的次数</p>
     *
     * @param content 给定的字符串
     * @return
     */
    private List<Node> getNodes(@NotNull String content) {
        List<Node> nodes = new ArrayList<>();
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getValue(), entry.getKey()));
        }
        return nodes;
    }

    @Data
    static class Zip {
        private int length; // 二进制字符串，最后一位有效位数
        private byte[] data; // 压缩后的数据
    }

    @Data
    static class Node implements Comparable<Node> {
        private int weight; // 节点的权值
        private Byte data; // 节点保存的数据
        private Node left; // 左子节点
        private Node right; // 右子节点

        public Node(int weight, Byte data) {
            this.weight = weight;
            this.data = data;
        }

        /**
         * 前序遍历
         */
        public void preOrder() {
            System.out.println(this);
            if (left != null) {
                left.preOrder();
            }
            if (right != null) {
                right.preOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", data=" + data +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            // 从小到大排序
            return weight - o.weight;
        }
    }
}
