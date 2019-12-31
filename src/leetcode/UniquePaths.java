package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class UniquePaths {
    @Test
    public void fun() {
        int method = uniquePaths(3, 2);
        System.out.println(method);
    }

    /**
     * 路径
     */
    private int uniquePaths(int m, int n) {
        if ((m == 0) || (n == 0)) {
            return 0;
        }
        if ((m == 1) || (n == 1)) {
            return 1;
        }
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
