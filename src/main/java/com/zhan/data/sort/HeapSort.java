package com.zhan.data.sort;

/**
 * @Author Zhanzhan
 * @Date 2020/10/17 16:23
 * 堆排序，运用到了顺序存储二叉树
 */
public class HeapSort {

    /**
     * <p>堆排序，思路:</p>
     * <p>1、将数组转化为大顶堆，可以使用顺序存储二叉树，不一定真的用二叉树，使用数组来顺序存储模拟二叉树，关于大顶堆的概念可以百度</p>
     * <p>2、将大顶堆的根节点，即root节点取出，放到数组的末尾，并移出大顶堆，因为根节点是全局最大的数，所以放到最后</p>
     * <p>3、重新将剩余的数据构建大顶堆，然后将root节点取出放到倒数第二位，即循环 1 和 2步骤，这样最终的数组就是升序排列的</p>
     *
     * @param arr
     */
    public void heapSort(int[] arr) {
        int temp;
        int length = arr.length; // 数组长度
        // length / 2 为完全二叉树中非叶子节点的个数， -1 就是最后一个非叶子节点的下标，
        // 从最后一个非叶子节点开始，逐步构建大顶堆，即从下往上，从右至左
        for (int i = length / 2 - 1; i >= 0; i--) {
            constructHeap(arr, i, length);
        }

        // 因为构建完大顶堆后，下标为0的元素一定是整个数组中最大的元素，
        // 就依次交换数组末尾的元素，将大的数按顺序放入数组的末尾
        for (int j = length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            constructHeap(arr, 0, j);
        }
    }

    /**
     * 将给定的数组以下标为 i 的非叶子节点的树调整为大顶堆
     *
     * @param arr    要构建大顶堆的数组
     * @param i      表示非叶子节点在数组中的下标
     * @param length 表示对多少个元素进行调整构建，length的值是逐渐减少的
     */
    public void constructHeap(int[] arr, int i, int length) {
        int temp = arr[i]; // 先取出要调整的非叶子节点的值
        // i * 2 + 1 是之前学过的顺序存储二叉树中的 左子节点下标
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 如果左子节点的值小于右子节点
                k++; // 将 k 指向右子节点
            }
            if (arr[k] > temp) { // 比较左右子节点和父节点的大小，如果左右子节点中有一个大于父节点
                arr[i] = arr[k]; // 将较大的值赋给当前节点，即父节点
                i = k; // i 指向 k，继续循环比较
            } else {
                break;
            }
        }
        // for循环结束后，我们已经将下标为 i 为父节点的树的最大值，放在了顶部（局部树）
        arr[i] = temp;// 将 temp 的值放到调整后的位置上
    }
}
