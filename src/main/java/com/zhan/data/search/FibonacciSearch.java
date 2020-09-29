package com.zhan.data.search;

import java.util.Arrays;

/**
 * @Author zhan
 * @Date 2020/9/29 20:20
 * 斐波那契查找
 */
public class FibonacciSearch {
    private static int maxSize = 20;

    /**
     * <p>获取一个斐波那契数列</p>
     * <p>后面的数等于前两个数之和</p>
     *
     * @return 斐波那契数列
     */
    public int[] fibonacciSequence() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * <p>斐波那契查找</p>
     * <p>思路参考:
     *
     * @param arr   要查找的数组
     * @param value 要查找的值
     * @return
     * @see <a href="https://blog.csdn.net/qq_41056506/article/details/81874439">斐波那契文章</a>
     * </p>
     * <p>大体和二分查找类似，区别也是在于中间下标mid的选取</p>
     * <p>斐波那契查找，是将数组一分为二，左侧(前一部分)和右侧(后一部分)的个数满足斐波那契数列，即比值接近黄金分割0.618</p>
     */
    public int fibonacciSearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0; // 斐波那契分割数值下标
        int mid = 0;
        int[] f = fibonacciSequence(); // 斐波那契数列
        // 获取斐波那契分割数值下标
        while (right > f[k] - 1) {
            k++;
        }

        // 构造一个数组，并指向arr，即copy arr数组，但是大小用的是 斐波那契分割数值，即f[k]
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 因为有可能构造的新数组，长度比原始数组要长，因此长出的那部分用arr原始数组的最后一个数填充
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        // 接下来就是真正的查找
        while (left <= right) {
            // 以下两个判断，网上的文章中都没有，容易造成f[k -1]下标越界，就是在找到最右侧或者最左侧时出现的，
            // 比如就把下面两个判断去除，然后在单元测试里查找1000试试
            if (left == right && value != arr[left]) {
                break;
            }
            if (left == right && value == arr[left]) {
                return left;
            }
            mid = left + f[k - 1] - 1;
            if (value > arr[mid]) { // 关键字大于分割位置的值，则继续查找右侧(后一部分)
                left = mid + 1;
                /**全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为后部有f[k-2]个元素,所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
                 * 即在f[k-2]的前部继续查找 所以k-=2
                 * 即下次循环 mid=f[k-1-2]-1
                 */
                k -= 2;
            } else if (value < arr[mid]) { // 关键字小于分割位置的值，则继续查找左侧(前一部分)
                right = mid - 1;
                /**全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为前部有f[k-1]个元素,所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                 * 即在f[k-1]的前部继续查找 所以k--
                 * 即下次循环 mid=f[k-1-1]-1
                 */
                k--;
            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }
}
