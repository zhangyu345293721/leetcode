package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 905 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-array-by-parity
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SortArrayByParity905 {

    @Test
    public void sortArrayByParityTest() {
        int[] arr = {1, 2, 3, 4};
        int[] result = sortArrayByParity(arr);
        Assert.assertEquals(result[0], 4);
    }

    /**
     * 对数组进行分类并返回
     *
     * @param A 数组
     * @return 数组
     */
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                i++;
            } else if (A[j] % 2 == 1) {
                j--;
            } else {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return A;
    }

    /**
     * 交换两个元素的位置
     *
     * @param a 数组
     * @param i 位置i
     * @param j 位置j
     */
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
