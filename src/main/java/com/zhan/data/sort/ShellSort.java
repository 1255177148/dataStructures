package com.zhan.data.sort;

import lombok.Data;

import java.util.Random;

/**
 * @Author zhan
 * @Date 2020/9/22 21:14
 * 希尔排序
 */
@Data
public class ShellSort {
    private int[] arr;
    private int size;

    /**
     * 初始化一个数组
     *
     * @param size 数组的长度
     */
    public ShellSort(int size) {
        this.size = size;
        this.arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(80000);
        }
    }

    /**
     * <p>希尔排序--分组互换</p>
     * <p>思路:
     * <blockquote><pre>
     *     1、先将一组数据分组,可以根据数组的长度 l / 2的结果Stride为步长,然后从下标为0开始依据步长分组;
     *     2、然后每个分组内比较大小,然后互换,将值小的放前面;
     *     3、再将步长Stride / 2得到新的步长,重复1、2步,直到步长小于1为止.
     * </pre></blockquote>
     * </p>
     * <p>就是先逻辑分组,然后在每个分组内用插入排序</p>
     */
    public void sortByChange() {
        int temp;
        long start = System.currentTimeMillis();
        for (int stride = size / 2; stride > 0; stride /= 2) {
            for (int i = stride; i < size; i++) {
                for (int j = i - stride; j >= 0; j -= stride) {
                    if (arr[j] > arr[j + stride]) {
                        temp = arr[j];
                        arr[j] = arr[j + stride];
                        arr[j + stride] = temp;
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总共耗时" + (end - start) / 1000 + "秒");
    }

    /**
     * <p>希尔排序--分组互换</p>
     * <p>思路:
     * <blockquote><pre>
     *     1、先将一组数据分组,可以根据数组的长度 l / 2的结果Stride为步长,然后从下标为0开始依据步长分组;
     *     2、然后每个分组内使用插入排序;
     *     3、再将步长Stride / 2得到新的步长,重复1、2步,直到步长小于1为止.
     * </pre></blockquote>
     * </p>
     * <p>就是先逻辑分组,然后在每个分组内用插入排序</p>
     */
    public void sortByMove() {
        long start = System.currentTimeMillis();
        for (int stride = size / 2; stride > 0; stride /= 2) {
            // 下面的逻辑就是使用的插入排序
            for (int i = stride; i < size; i++) {
                int j = i;
                int temp = arr[j];
                while (j - stride >= 0 && temp < arr[j - stride]) {
                    arr[j] = arr[j - stride];
                    j -= stride;
                }
                arr[j] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总共耗时" + (end - start) / 1000 + "秒");
    }
}
