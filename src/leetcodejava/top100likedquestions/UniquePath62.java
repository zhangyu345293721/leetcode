package leetcodejava.top100likedquestions;

import org.junit.Test;

/**
 * 独特的路径
 *
 * @author: zhangyu
 */
public class UniquePath62 {
    @Test
    public void testUniquePath() {
        int n = 3;
        int m = 7;
        int methods = paths(m, n);
        System.out.println(methods);
    }

    /**
     * 总的种数
     *
     * @param m 数字m
     * @param n 数字n
     * @return 次数
     */
    private int paths(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
