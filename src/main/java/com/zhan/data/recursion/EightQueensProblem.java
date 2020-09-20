package com.zhan.data.recursion;

import lombok.Data;

/**
 * @Author Zhanzhan
 * @Date 2020/9/20 16:51
 * 八皇后问题
 */
@Data
public class EightQueensProblem {

    // 有几个皇后
    private int max;
    // 放置八皇后摆法，下标+1为第几个皇后，arr[i]的值+1为第i+1个皇后摆放的列
    private int[] arr;
    private static int count = 0;
    private static int answer = 0;

    public EightQueensProblem(int max) {
        this.max = max;
        this.arr = new int[max];
    }

    /**
     * 返回问题答案的个数
     * @return 问题答案的个数
     */
    public int getAnswer(){
        return answer;
    }

    /**
     * 返回递归了多少次
     * @return 递归的次数
     */
    public int getCount(){
        return count;
    }

    /**
     * 放置皇后，从第n个皇后开始放置
     * @param n 第n个皇后
     */
    public void putQueen(int n) {
        if (n > max) {
            printAnswer();
            return;
        }
        for (int i = 0; i < max; i++) {
            // 在每一次进入这个for循环遍历的时候,先把当前的皇后放在该行的第1列,此时i就等于0,即第一列
            arr[n - 1] = i; // 如果放第一列冲突的时候，再重新遍历，此时i++，即将当前皇后放在下一列
            // 判断当前第n个皇后放置在(i+1)列时，是否冲突
            if (check(n)) {
                // 如果不冲突，继续放(n+1)个皇后，即开始递归，直到放置完皇后为止
                putQueen(n + 1);
            }
        }
    }

    /**
     * <p>当我们放置第n个皇后,就检测下该皇后是否和前面已经放置的皇后冲突</p>
     * <p>
     * 产生冲突的场景为:
     * <blockquote><pre>
     *        1、和前面的皇后在同一列;
     *        2、和前面的皇后在同一斜线;
     *        3、和前面的皇后在同一行.
     *     </pre></blockquote>
     * </p>
     *
     * @param n 第n个皇后
     * @return 时候冲突
     */
    private boolean check(int n) {
        for (int i = 0; i < n - 1; i++) {
            count++;
            // if条件里的条件说明
            // 1、arr[i] == arr[n - 1] 表示判断第n个皇后是否和前面的(n-1)个皇后在同一列
            // 2、Math.abs()是求绝对值，Math.abs(n - 1 -i) == Math.abs(arr[n - 1] - arr[i]) 表示判断第n个皇后是否和第i个皇后在同一斜线
            if (arr[i] == arr[n - 1] || Math.abs(n - 1 - i) == Math.abs(arr[n - 1] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印八皇后问题答案
     */
    private void printAnswer() {
        answer++;
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
