package com.zhan.data.tree;

import lombok.Data;

/**
 * @Author zhan
 * @Date 2020/10/15 21:32
 * 顺序存储二叉树
 */
@Data
public class ArrBinaryTree {
    private int[] arr; // 存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * <p>使用数组存储完全二叉树，并且用前序遍历，遍历此数组</p>
     * <p>下标为 n 的节点的左子节点下标为 2n+1 , 右子节点为 2n+2, 父节点为 (n-1)/2</p>
     */
    public void preOrder(){
        preOrder(0);
    }

    /**
     * 使用数组进行树的中序遍历
     */
    public void inOrder(){
        inOrder(0);
    }

    /**
     * 使用数组进行树的后序遍历
     */
    public void postOrder(){
        postOrder(0);
    }

    /**
     * <p>使用数组存储完全二叉树，并且用前序遍历，遍历此数组</p>
     * <p>下标为 n 的节点的左子节点下标为 2n+1 , 右子节点为 2n+2, 父节点为 (n-1)/2</p>
     * @param index
     */
    private void preOrder(int index){
        int length;
        int n;
        if (arr == null || (length = arr.length) == 0){
            System.out.println("数组为空，不能使用树的前序遍历进行遍历");
            return;
        }

        System.out.print(arr[index] + "\t");

        // 遍历左子节点
        if ((n = index * 2 + 1) < length){
            preOrder(n);
        }

        // 遍历右子节点
        if ((n = index * 2 + 2) < length){
            preOrder(n);
        }
    }

    /**
     * 使用数组进行中序遍历
     * @param index
     */
    private void inOrder(int index){
        int length,n;
        if (arr == null || (length = arr.length) == 0){
            System.out.println("数组为空，不能使用树的中序遍历进行遍历");
            return;
        }

        // 遍历左子节点
        if ((n = index * 2 + 1) < length){
            inOrder(n);
        }

        // 输出当前节点
        System.out.print(arr[index] + "\t");

        // 遍历右子节点
        if ((n = index * 2 + 2) < length){
            inOrder(n);
        }
    }

    /**
     * 使用数组进行树的后序遍历
     * @param index
     */
    private void postOrder(int index){
        int length,n;
        if (arr == null || (length = arr.length) == 0){
            System.out.println("数组为空，不能使用树的后序遍历进行遍历");
            return;
        }
        // 遍历左子节点
        if ((n = index * 2 + 1) < length){
            postOrder(n);
        }

        // 遍历右子节点
        if ((n = index * 2 + 2) < length){
            postOrder(n);
        }

        // 输出当前节点
        System.out.print(arr[index] + "\t");
    }
}
