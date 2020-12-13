package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.62 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-paths/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class UniquePath62 {
    @Test
    public void uniquePathTest() {
        int n = 3;
        int m = 7;
        int methods = paths(m, n);
        Assert.assertEquals(methods, 28);
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
        int[][] dp = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= n - 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
