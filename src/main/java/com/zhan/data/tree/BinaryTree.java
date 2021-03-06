package com.zhan.data.tree;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/10/11 15:21
 * 二叉树
 */
@Data
public class BinaryTree {

    private Node root;

    /**
     * <p>前序遍历</p>
     * <p>1、先输出父节点</p>
     * <p>2、然后向左递归遍历输出</p>
     * <p>3、最后向右递归遍历输出</p>
     */
    public void preOrder(){
        if (root != null){
            root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * <p>中序遍历</p>
     * <p>1、先向左递归遍历输出</p>
     * <p>2、然后输入父节点</p>
     * <p>3、最后向右递归遍历输出</p>
     */
    public void inOrder(){
        if (root != null){
            root.inOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * <p>后序遍历</p>
     * <p>1、先向左递归遍历输出</p>
     * <p>2、最后向右递归遍历输出</p>
     * <p>3、然后输入父节点</p>
     */
    public void postOrder(){
        if (root != null){
            root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * <p>前序查找,思路:</p>
     * <p>1、先比较当前节点，如果一致则返回;</p>
     * <p>2、若和当前节点不一致，则向左递归前序查找,如果找到则返回;</p>
     * <p>3、若没有找到，再向右递归前序查找，如果找到则返回</p>
     * @param key 要查找的key
     * @return
     */
    public Node preOrderSearch(int key){
        if (root == null){
            return null;
        }
        return root.preOrderSearch(key);
    }

    /**
     * <p>中序查找，思路:</p>
     * <p>1、先向左递归中序查找，如果找到则返回;</p>
     * <p>2、若没有找到，则比较当前节点，找到就返回;</p>
     * <p>3、若没有找到，则向右递归中序查找，找到就返回</p>
     * @param key 要查找的key
     * @return
     */
    public Node inOrderSearch(int key){
        if (root == null){
            return null;
        }
        return root.inOrderSearch(key);
    }

    /**
     * <p>后序查找，思路:</p>
     * <p>1、先向左递归中序查找，如果找到则返回;</p>
     * <p>2、若没有找到，则向右递归中序查找，找到就返回</p>
     * <p>3、若没有找到，则比较当前节点，找到就返回;</p>
     * @param key 要查找的key
     * @return
     */
    public Node postOrderSearch(int key){
        if (root == null){
            return null;
        }
        return root.postOrderSearch(key);
    }

    /**
     * <p>递归删除节点</p>
     * <p>规定:如果删除的是叶子节点，则删除该节点；如果删除的是非叶子节点，则删除该子树</p>
     * <p>思路：</p>
     * <p>1、从root节点开始，如果root节点为要删除的节点，则将整个数 = null；</p>
     * <p>2、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，则将 left = null, 并结束递归</p>
     * <p>3、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，则将 right = null, 并结束递归</p>
     * <p>4、如果 2 和 3 步没有删除节点，那么我们就需要向左子树进行递归删除</p>
     * <p>5、如果 4 也没有删除节点，则应向右子树进行递归删除</p>
     * @param key 要删除的key
     * @return 是否删除
     */
    public boolean delNode(int key){
        if (root == null){
            return true;
        }
        if (root.key == key){
            root = null;
            return true;
        } else {
            root.delNode(key);
        }
        return true;
    }

    @Data
    static class Node{
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
         * <p>前序遍历</p>
         * <p>1、先输出父节点</p>
         * <p>2、然后向左递归遍历输出</p>
         * <p>3、最后向右递归遍历输出</p>
         */
        public void preOrder(){
            System.out.println(this); // 先输出父节点
            // 递归向左子树遍历
            if (left != null){
                left.preOrder();
            }
            // 递归向右子树遍历
            if (right != null){
                right.preOrder();
            }
        }

        /**
         * <p>中序遍历</p>
         * <p>1、先向左递归遍历输出</p>
         * <p>2、然后输入父节点</p>
         * <p>3、最后向右递归遍历输出</p>
         */
        public void inOrder(){
            // 递归向左子树遍历
            if (left != null){
                left.inOrder();
            }
            System.out.println(this); // 输出父节点
            // 递归向右子树遍历
            if (right != null){
                right.inOrder();
            }
        }

        /**
         * <p>后序遍历</p>
         * <p>1、先向左递归遍历输出</p>
         * <p>2、最后向右递归遍历输出</p>
         * <p>3、然后输入父节点</p>
         */
        public void postOrder(){
            // 递归向左子树遍历
            if (left != null){
                left.postOrder();
            }

            // 递归向右子树遍历
            if (right != null){
                right.postOrder();
            }

            System.out.println(this); // 输出父节点
        }

        /**
         * <p>前序查找,思路:</p>
         * <p>1、先比较当前节点，如果一致则返回;</p>
         * <p>2、若和当前节点不一致，则向左递归前序查找,如果找到则返回;</p>
         * <p>3、若没有找到，再向右递归前序查找，如果找到则返回</p>
         * @param key 要查找的key
         * @return
         */
        public Node preOrderSearch(int key){
            // 先比较当前节点
            if (this.key == key){
                return this;
            }

            Node result = null;
            // 再向左递归前序查找
            if (left != null){
                result = left.preOrderSearch(key);
            }
            if (result != null){
                return result;
            }
            // 如果没有找到，则向右递归前序查找
            if (right != null){
                result = right.preOrderSearch(key);
            }
            return result;
        }

        /**
         * <p>中序查找，思路:</p>
         * <p>1、先向左递归中序查找，如果找到则返回;</p>
         * <p>2、若没有找到，则比较当前节点，找到就返回;</p>
         * <p>3、若没有找到，则向右递归中序查找，找到就返回</p>
         * @param key 要查找的key
         * @return
         */
        public Node inOrderSearch(int key){
            Node result = null;

            // 先向左递归中序查找
            if (left != null){
                result = left.inOrderSearch(key);
            }
            if (result != null){
                return result;
            }

            // 若没有找到，再比较当前节点
            if (this.key == key){
                return this;
            }

            // 若还没有找到，最后向右递归中序查找
            if (right != null){
                result = right.inOrderSearch(key);
            }
            return result;
        }

        /**
         * <p>后序查找，思路:</p>
         * <p>1、先向左递归中序查找，如果找到则返回;</p>
         * <p>2、若没有找到，则向右递归中序查找，找到就返回</p>
         * <p>3、若没有找到，则比较当前节点，找到就返回;</p>
         * @param key 要查找的key
         * @return
         */
        public Node postOrderSearch(int key){
            Node result = null;

            // 先向左递归中序查找
            if (left != null){
                result = left.postOrderSearch(key);
            }
            if (result != null){
                return result;
            }

            // 若没有找到，则向右递归中序查找
            if (right != null){
                result = right.postOrderSearch(key);
            }
            if (result != null){
                return result;
            }

            // 若没有找到，再比较当前节点
            if (this.key == key){
                return this;
            }
            return null;
        }

        /**
         * <p>递归删除节点</p>
         * <p>规定:如果删除的是叶子节点，则删除该节点；如果删除的是非叶子节点，则删除该子树</p>
         * <p>思路：</p>
         * <p>1、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，则将 left = null, 并结束递归</p>
         * <p>2、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，则将 right = null, 并结束递归</p>
         * <p>3、如果 1 和 2 步没有删除节点，那么我们就需要向左子树进行递归删除</p>
         * <p>4、如果 3 也没有删除节点，则应向右子树进行递归删除</p>
         * @param key 要删除的key
         */
        public boolean delNode(int key){
            if (left != null && left.key == key){
                left = null;
                return true;
            }
            if (right != null && right.key == key){
                right = null;
                return true;
            }
            boolean isDel = false;
            if (left != null){
                isDel = left.delNode(key);
            }
            if (!isDel && right != null){
                isDel = right.delNode(key);
            }
            return isDel;
        }
    }
}
