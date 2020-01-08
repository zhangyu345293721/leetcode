package leetcode.java.top100likedquestions;

import org.junit.Test;

/**
 * 找出一个数是平方组成
 *
 * @author: zhangyu
 */
public class PerfectSquares279 {
    @Test
    public void testPerfectSquares() {
        int num = 13;
        int result = numSquares(num);
        System.out.println(result);
    }

    /**
     * 这个数由几个完全平方组成
     *
     * @param n 输入数字
     * @return 多少数组成
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k * k <= i; k++) {
                min = Math.min(min, 1 + dp[i - k * k]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
