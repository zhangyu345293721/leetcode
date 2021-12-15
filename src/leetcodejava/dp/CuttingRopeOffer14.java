package leetcodejava.dp;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.518 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CuttingRopeOffer14 {

    @Test
    public void cuttingRopeOffer() {
        int n = 10;
        int result = cuttingRope(n);
        System.out.println(result);
        Assert.assertEquals(result, 36);
    }

    /**
     * 剪绳子
     *
     * @param n n长
     * @return 相乘最大值
     */
    public int cuttingRope(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 3;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i] < j * dp[i - j]) {
                    dp[i] = j * dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
