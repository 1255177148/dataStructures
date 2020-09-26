package com.zhan.data.sort;

/**
 * @Author Zhanzhan
 * @Date 2020/9/26 16:38
 * 基数排序
 */
public class BaseSort {

    private final static int number = 10; //桶的个数

    /**
     * <p>基数排序</p>
     * <p>思路:
     * <blockquote><pre>
     *     1、先定义十个数组，或者一个二维数组，里面包含十个数组，即十个桶，下标依次为0-9;
     *     2、然后遍历出数组最大的数，得到其位数，即为接下来排序时要循环的次数;
     *     3、然后先取数组中每个元素的个位数，值为0就放下标为0的桶中，这样为例，依次放到桶里;
     *     4、然后从桶中按下标顺序依次取出并放回数组中;
     *     5、然后再去数组每个元素的十位数，重复步骤3和4，这样直到取到最大数的位数为止。
     * </pre></blockquote>
     * </p>
     * @param arr 要排序的原始数组
     */
    public void baseSort(int[] arr){
        if (arr.length <= 0){
            return;
        }
        // 定义一个二维数组，用来定义桶
        int[][] bucket = new int[number][arr.length];

        // 定义一个数组，用来标识每个桶中的有效数据个数
        int[] bucketCount = new int[number];

        // 遍历，获取数组中最大的数的位数
        int max = arr[0];
        for (int data : arr){
            if (data > max){
                max = data;
            }
        }
        int maxLength = String.valueOf(max).length();

        for (int i = 0, n = 1;i<maxLength;i++,n*=10){
            // 每一轮中针对每个元素对应的位进行排序
            for (int l = 0;l<arr.length;l++){
                // 取出每个元素对应位数的值
                int value = arr[l] / n % 10;
                // 放到对应的桶中
                bucket[value][bucketCount[value]] = arr[l];
                bucketCount[value]++;
            }

            // 按照桶的顺序，依次取出放到原始数组中
            int index = 0;
            for (int j = 0;j<number;j++){
                // 如果桶中有数据，才放入到数组中
                if (bucketCount[j] != 0){
                    for (int k = 0;k<bucketCount[j];k++){
                        arr[index++] = bucket[j][k];
                    }
                    bucketCount[j] = 0;
                }
            }
        }
    }
}
