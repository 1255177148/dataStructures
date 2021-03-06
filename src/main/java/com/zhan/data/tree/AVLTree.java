package com.zhan.data.tree;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/11/3 20:38
 * 平衡二叉树
 */
@Data
public class AVLTree {

    private Node root;

    /**
     * <p>添加一个节点到二叉排序树种</p>
     * <p>保证节点的左子节点小于自己，节点的右子节点大于自己</p>
     *
     * @param node 要添加的节点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("当前二叉排序树为空");
            return;
        }
        root.inOrder();
    }

    /**
     * 查找要删除的节点
     *
     * @param key 要删除节点的值
     * @return 要删除的节点
     */
    public Node search(int key) {
        if (root == null) {
            return null;
        }
        return root.search(key);
    }

    /**
     * 查找要删除的节点的父节点
     *
     * @param key 要删除的节点的值
     * @return 要删除节点的父节点
     */
    public Node searchParent(int key) {
        if (root == null) {
            return null;
        }
        return root.searchParent(key);
    }

    /**
     * <p>删除指定的节点,思路:</p>
     * <blockquote><pre>
     * 先找到要删除的目标节点 targetNode 和父节点 parent, 这时 targetNode 会有以下三种情况
     * 一、删除叶子节点时:
     *   1、确定 targetNode 是 parent 的左子节点还是右子节点;
     *   2、如果是左子节点, 则 parent.left = null, 否则 parent.right = null
     * 二、删除只有一颗子树的节点时:
     *   1、首先看 targetNode 是否是根节点，即 parent 为 null
     *   2、如果 targetNode 有左子节点
     *    2.1、如果 parent 为 null , 则 root = targetNode.left, 即让 targetNode 的左子节点为 root 节点
     *    2.2、如果 parent 不为 null,且 targetNode 是 parent的左子节点，则 parent.left = targetNode.left,将 targetNode 的左子节点提上来
     *    2.3、如果 parent 不为 null,且 targetNode 是 parent的右子节点，则parent.right = targetNode.left,将 targetNode 的左子节点提上来
     *   3、如果 targetNode 有右子节点
     *    3.1、如果 parent 为 null , 则 root = targetNode.right, 即让 targetNode 的右子节点为 root 节点
     *    3.2、如果 parent 不为 null,且 targetNode 是 parent的左子节点，则 parent.left = targetNode.right,将 targetNode 的右子节点提上来
     *    3.3、如果 parent 不为 null,且 targetNode 是 parent的右子节点，则parent.right = targetNode.right,将 targetNode 的右子节点提上来
     * 三、删除有两棵子树的节点时:
     *   1、从 targetNode 的右子树中找到最小的节点
     *   2、用一个临时变量 temp 保存找到的最小节点的值,然后删除该最小节点
     *   3、将 temp 赋给 targetNode, targetNode.key = temp,也就是实现将右子树的最小节点提上来,替换 targetNode
     * </pre></blockquote>
     *
     * @param key 要删除的节点的值
     */
    public void remove(int key) {
        if (root == null) {
            return;
        }
        // 1、先找到要删除的节点
        Node targetNode = search(key);
        if (targetNode == null) { // 如果找不到要删除的节点
            return;
        }
        // 2、如果目标节点是根节点，并且此树只有根节点这一个节点，那么直接删除根节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        // 3、找到目标节点的根节点
        Node parent = searchParent(key);
        // 4、如果要删除的节点是叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            // 判断目标节点是父节点的左子节点还是右子节点
            if (parent.left != null && parent.left.key == key) { // 如果是左子节点
                parent.left = null;
            } else { // 如果是右子节点
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) { // 5、如果目标节点有两颗子树
            NodeData nodeData = removeRightTreeMin(targetNode.right);
            targetNode.setKey(nodeData.key);
            targetNode.setValue(nodeData.value);
        } else { // 6、如果目标节点有一颗子树
            boolean leftFlag = targetNode.left != null; // 标记targetNode是否有左子树
            if (parent == null) {
                // 如果 parent 为null，这时root节点就是targetNode，则将targetNode的左子节点或者右子节点赋给root
                root = leftFlag ? targetNode.left : targetNode.right;
            } else if (parent.left != null && parent.left.key == key) {
                // 如果 targetNode是parent的左子节点
                parent.left = leftFlag ? targetNode.left : targetNode.right;
            } else {
                // 如果 targetNode是parent的右子节点
                parent.right = leftFlag ? targetNode.left : targetNode.right;
            }
        }
    }

    /**
     * <p>根据传入的节点为根节点root，循环查找左子树节点，直到查找到最小值，即最左的子节点</p>
     * <p>然后返回此节点的有效数据，并删除此节点</p>
     *
     * @param node 传入的节点，作为根节点查找
     * @return 以node为根节点的二叉排序树的最小节点的有效数据
     */
    private NodeData removeRightTreeMin(Node node) {
        Node target = node;
        // 循环向左子树查找，直到找到最小值，即left为null
        while (target.left != null) {
            target = target.left;
        }
        // 这时 target已经是最小节点了
        // 删除此节点，并返回此节点的值
        NodeData nodeData = new NodeData();
        nodeData.setKey(target.getKey());
        nodeData.setValue(target.getValue());
        remove(target.getKey());
        return nodeData;
    }

    @Data
    private static class NodeData {
        private int key;
        private String value;
    }

    @Data
    static class Node {
        private int key;
        private String value;
        private Node left;
        private Node right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }

        /**
         * 获取当前节点左子树的高度
         *
         * @return 当前节点左子树的高度
         */
        public int leftHeight() {
            return left == null ? 0 : left.height();
        }

        /**
         * 获取当前节点右子树的高度
         * @return 当前节点右子树的高度
         */
        public int rightHeight() {
            return right == null ? 0 : right.height();
        }

        /**
         * 获取以当前节点为根节点的树的高度
         *
         * @return 当前节点为根节点的树的高度
         */
        public int height() {
            // 这里用递归分别获取左子树和右子树的高度，然后取最大值
            return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
        }

        /**
         * <p>平衡二叉树的左旋，对二叉树进行左旋，已达到平衡二叉树，思路:</p>
         * <blockquote><pre>
         *     1、创建新的节点，值就为当前根节点的值;
         *     2、把新的节点的左子树设置成当前节点的左子树;
         *     3、把新的节点的右子树设置成当前节点的右子树的左子树;
         *     4、把当前节点的值换成其右子节点的值;
         *     5、把当前节点的右子节点指向其右子节点的右子节点;
         *     6、把当前节点的左子节点设置成新的节点.
         * </pre></blockquote>
         */
        private void leftRotate(){
            // 创建新的节点
            Node newNode = new Node(key,value);
            // 把新的节点的左子树设置成当前节点的左子树
            newNode.left = left;
            // 把新的节点的右子树设置成当前节点的右子树的左子树
            newNode.right = right.left;
            // 把当前节点的值换成其右子节点的值
            key = right.key;
            value = right.value;
            // 把当前节点的右子节点指向其右子节点的右子节点
            right = right.right;
            // 把当前节点的左子节点设置成新的节点
            left = newNode;
        }

        /**
         * <p>平衡二叉树的右旋，对二叉树进行右旋，已达到平衡二叉树，思路:</p>
         * <blockquote><pre>
         *     1、创建新的节点，值就为当前根节点的值;
         *     2、把新的节点的右子树设置成当前节点的右子树;
         *     3、把新的节点的左子树设置成当前节点的左子树的右子树;
         *     4、把当前节点的值换成其左子节点的值;
         *     5、把当前节点的左子节点指向其左子节点的左子节点;
         *     6、把当前节点的右子节点设置成新的节点.
         * </pre></blockquote>
         */
        private void rightRotate(){
            // 创建新的节点
            Node newNode = new Node(key,value);
            // 把新的节点的右子树设置成当前节点的右子树
            newNode.right = right;
            // 把新的节点的左子树设置成当前节点的左子树的右子树
            newNode.left = left.right;
            // 把当前节点的值换成其左子节点的值
            key = left.key;
            value = left.value;
            // 把当前节点的左子节点指向其左子节点的左子节点
            left = left.left;
            // 把当前节点的右子节点设置成新的节点
            right = newNode;
        }

        /**
         * <p>添加一个节点到二叉排序树种</p>
         * <p>保证节点的左子节点小于自己，节点的右子节点大于自己</p>
         * <p>还要保证此树是一个为平衡二叉树，即左右两子树的高度差不大于1</p>
         *
         * @param node 要添加的节点
         */
        public void add(Node node) {
            if (node == null) {
                return;
            }
            Node temp = this;
            // 这里是用 while 循环替代递归，不断向子树递归，直到找到要插入的位置
            while (true) {
                // 比较传入的节点和当前节点的值大小
                if (node.key < temp.key) { // 如果传入的节点的值小于当前节点
                    // 如果当前节点左子节点为null
                    if (temp.left == null) {
                        // 将节点添加到左子节点上
                        temp.left = node;
                        break;
                    } else { // 如果当前节点左子节点不为null,则继续向下查询，获取要插入的位置
                        temp = temp.left; // 继续向左子节点递归查找
                    }
                } else { // 如果传入的节点的值大于等于当前节点
                    // 如果当前节点右子节点为null
                    if (temp.right == null) {
                        // 将节点添加到右子节点上
                        temp.right = node;
                        break;
                    } else { // 如果当前节点右子节点不为null,则继续向下查询，获取要插入的位置
                        temp = temp.right; // 继续向右子节点递归查找
                    }
                }
            }
            // 当添加完一个节点后，如果 (右子树的高度 - 左子树的高度) > 1，则左旋转
            if (rightHeight() - leftHeight() > 1){
                // 如果它的右子树的 左子树的高度 大于 它的右子树的 右子树的高度
                if (right != null && right.leftHeight() > right.rightHeight()){
                    // 以当前节点的 右子节点 为子树的根节点，进行右旋转
                    right.rightRotate();
                }
                leftRotate();// 左旋转
                return;
            }

            // 当添加完一个节点后，如果(左子树的高度 - 右子树的高度) > 1，则右旋转
            if (leftHeight() - rightHeight() > 1){
                // 如果它的左子树的右子树高度大于它的左子树的左子树高度
                if (left != null && left.rightHeight() > left.leftHeight()){
                    // 以当前节点的左节点为子树的根节点，进行左旋转
                    left.leftRotate();
                }
                rightRotate();
            }
        }

        /**
         * 中序遍历
         */
        public void inOrder() {
            if (this.left != null) {
                left.inOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                right.inOrder();
            }
        }

        /**
         * 根据指定的值查找节点
         *
         * @param key 要查找的值
         * @return 对应的节点
         */
        public Node search(int key) {
            Node temp = this;
            while (true) {
                if (temp == null) {
                    return null;
                }
                // 找到就返回该节点
                if (temp.key == key) {
                    return temp;
                }
                if (key < temp.key) { // 如果要找的值小于当前节点的值
                    // 向左子节点继续查找
                    temp = temp.left;
                } else { // 如果要找的值大于当前节点的值
                    // 向右子节点继续查找
                    temp = temp.right;
                }
            }
        }

        /**
         * 查找要删除节点的父节点
         *
         * @param key 要删除的节点的值
         * @return 要删除节点的父节点
         */
        public Node searchParent(int key) {
            Node temp = this;
            while (true) {
                // 如果当前节点就是要删除的节点的父节点
                if ((temp.left != null && temp.left.key == key) ||
                        (temp.right != null && temp.right.key == key)) {
                    return temp;
                } else {
                    if (key < temp.key && temp.left != null) { // 如果目标值小于当前节点，并且当前节点的左子节点不为空
                        temp = temp.left; // 向左子节点继续查找
                    } else if (key >= temp.key && temp.right != null) { // 如果目标值大于等于当前节点，并且当前节点的右子节点不为空
                        temp = temp.right; // 向右子节点继续查找
                    } else {
                        return null;
                    }
                }
            }
        }
    }
}
