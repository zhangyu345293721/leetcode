package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 852 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *

 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PeakIndexMountainArray852 {
    @Test
    public void testPeakIndexMountainArray() {
        int[] arr = {0, 2, 1, 0};
        int index = peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    /**
     * 找出最高点的下标
     *
     * @param A 数组
     * @return 下标
     */
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
