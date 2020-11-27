package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No.896 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/monotonic-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[1,3,2]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class MonotonicArray896 {

    @Test
    public void monotonicArrayTest() {
        int[] arr = {1, 1, 1};
        boolean flag = isMonotonic(arr);
        System.out.println(flag);
    }

    /**
     * 动量数组
     *
     * @param A 数组
     * @return 返回是否递增和递减
     */
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] <= A[i]) {
                count1++;
            }
            if (A[i - 1] >= A[i]) {
                count2++;
            }
        }
        int time = A.length - 1;
        return count1 == time || count2 == time;
    }
}
