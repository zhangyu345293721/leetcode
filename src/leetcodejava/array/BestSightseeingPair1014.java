package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1014 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-sightseeing-pair
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BestSightseeingPair1014 {

    @Test
    public void bestSightseeingPairTest() {
        int[] A = {8, 1, 5, 2, 6};
        int result = maxScoreSightseeingPair(A);
        Assert.assertEquals(result, 4);
    }

    /**
     * 获取最好观景太
     *
     * @param A 数组
     * @return 观景最大值
     */
    public int maxScoreSightseeingPair(int[] A) {
        int length = A.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int total = A[i] + A[j] + i - j;
                if (total > result) {
                    result = total;
                }
            }
        }
        return result;
    }

    /**
     * 分别去数组最大值
     * 求最大值公式：total=A[i]+A[j]-i-j;可以分成量部分：A[i]+i 和A[j]-j的最大值
     *
     * @param A 数组A
     * @return 最大值
     */
    public int maxScoreSightseeingPair2(int[] A) {
        int left = A[0], res = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        return res;
    }
}
