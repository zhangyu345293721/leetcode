package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 69 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SubarraySumsDivisibleK974 {

    @Test
    public void subarraySumsDivisibleKTest() {
        int[] A = {4, 5, 0, -2, -3, 1};
        int K = 5;
        int i = subarraysDivByK(A, K);
        Assert.assertEquals(i, 7);
    }

    /**
     * 计算子数组和是固定值的整数倍
     *
     * @param A 数组
     * @param K 固定值
     * @return 种数
     */
    public int subarraysDivByK(int[] A, int K) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            if (sum % K == 0) {
                num++;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * 计算子数组和是固定值的整数倍
     *
     * @param A 数组
     * @param K 固定值
     * @return 种数
     */
    public int subarraysDivByK2(int[] A, int K) {
        int[] map = new int[K];
        ++map[0];
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (a + prefix) % K;
            if (prefix < 0) {
                prefix += K;
            }
            res += map[prefix]++;
        }
        return res;
    }
}
