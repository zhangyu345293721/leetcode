package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 977 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SquaresSortedArray977 {
    @Test
    public void squaresSortedArrayTest() {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] sortedArray = sortedSquares(arr);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    /**
     * 一个数组返回新数组
     *
     * @param arr 输入数组
     * @return 新数组
     */
    public int[] sortedSquares(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
