package com.zhan.data.hash;

import lombok.Data;

/**
 * @Author zhan
 * @Date 2020/10/5 14:37/
 * 哈希表模拟
 */
@Data
public class HashTable<K,V> {

    // 初始化桶的容量，必须是2的倍数
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private NodeLinkedList<K,V>[] table;
    private int size;

    public HashTable() {
        this.size = DEFAULT_INITIAL_CAPACITY;
        initialization(size);
    }

    public HashTable(int size) {
        this.size = size;
        initialization(size);
    }

    public Node<K,V> buildNode(K key, V value){
        return new Node<K,V>(key, value);
    }

    /**
     * 将节点存放到hash表中
     *
     * @param node 要存放的节点
     */
    public void add(Node<K,V> node) {
        // 根据key算出hash key,即桶的下标，得到该节点要放在哪个链表中
        int n = hash(node.key);
        table[n].add(node);
    }

    /**
     * 遍历hash表中的数据
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            table[i].list(i);
        }
    }

    /**
     * 根据key查找值
     * @param key 要查找值的key
     * @return
     */
    public V get(Object key){
        int n = hash(key);
        return table[n].get(key);
    }

    /**
     * 根据key删除对应的数据
     * @param key 要删除的key
     * @return 是否已删除，如果数据原本不存在，也会返回true
     */
    public boolean remove(Object key){
        int n = hash(key);
        return table[n].remove(key);
    }

    /**
     * 初始化hash表的桶
     *
     * @param size
     */
    private void initialization(int size) {
        this.table = (NodeLinkedList<K,V>[])new NodeLinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new NodeLinkedList<K,V>();
        }
    }

    /**
     * <p>使用散列函数，获取key的hash key</p>
     * <p>这里使用的是简单的取模</p>
     *
     * @param key 要存放的key
     * @return
     */
    private int hash(Object key) {
        return (int)key % size;
    }

    class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class NodeLinkedList<K,V> {
        private Node<K,V> head;

        /**
         * 在链表的最后添加一个节点
         *
         * @param node 要添加的节点
         */
        public void add(Node<K,V> node) {
            if (head == null) {
                head = node;
                return;
            }
            Node<K,V> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

        /**
         * 遍历当前链表
         */
        public void list(int n) {
            if (head == null) {
                System.out.println("第" + (n + 1) + "个链表为空");
                return;
            }
            System.out.print("第" + (n + 1) + "个链表的数据为:");
            Node<K,V> current = head;
            while (current != null) {
                System.out.printf("key = %S, value = %s\t", current.key, current.value);
                current = current.next;
            }
            System.out.println();
        }

        /**
         * 根据key获取对应的值
         * @param key 要查找值的key
         * @return
         */
        public V get(Object key){
            if (head == null){
                return null;
            }
            Node<K,V> current = head;
            while (current != null){
                if (key == current.key){
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }

        /**
         * 根据key删除对应的数据
         * @param key 要删除的key
         * @return 是否已删除，如果数据原本不存在，也会返回true
         */
        public boolean remove(Object key){
            if (head == null){
                return true;
            }
            Node<K,V> current = head;
            if (key == current.key){
                head = current.next;
                return true;
            }
            while (current.next != null){
                if (key == current.next.key){
                    current.next = current.next.next;
                    return true;
                }
            }
            return true;
        }
    }
}
