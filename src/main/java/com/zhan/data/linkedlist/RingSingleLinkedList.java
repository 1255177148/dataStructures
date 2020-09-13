package com.zhan.data.linkedlist;


/**
 * @Author zhan
 * @Date 2020/9/12 22:21
 */
public class RingSingleLinkedList {
    private Node first;

    /**
     * 创建一个环形单链表
     *
     * @param num 节点个数
     */
    public void create(int num) {
        if (num < 1) {
            System.out.println("指定创建环形单链表的个数有问题");
            return;
        }
        Node current = null;
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i, "");
            if (i == 1) {
                first = node;
                first.setNext(first);
                current = first;
            } else {
                current.setNext(node);
                node.setNext(first);
                current = node;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node current = first;
        while (true) {
            System.out.printf("节点的编号为%d\n", current.getNo());
            if (current.getNext() == first){
                break;
            }
            current = current.getNext();
        }
    }

    /**
     * 约瑟夫问题，统计出圈顺序
     * @param start 表示从第几个开始数
     * @param step 表示数几下
     * @param initialNum 表示最初有几个数据在圈里
     */
    public void count(int start, int step, int initialNum){
        if (first == null || start < 1 || start > initialNum){
            System.out.println("参数输入有误");
        }
        // 先将first指针移动到指定的开始数
        for (int i = 0;i<start-1;i++){
            first = first.getNext();
        }
        Node temp = first;
        while (temp.getNext() != first) {
            temp = temp.getNext();
        }

        while (temp != first){
            for (int i = 0;i< step -1;i++){
                first = first.getNext();
                temp = temp.getNext();
            }
            System.out.printf("节点%d出圈\t",first.getNo());
            first = first.getNext();
            temp.setNext(first);
        }
        System.out.println();
        System.out.printf("最后留在圈中的是%d",first.getNo());
    }
}
