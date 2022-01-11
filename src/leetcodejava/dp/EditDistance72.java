package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 72 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/edit-distance/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class EditDistance72 {
    @Test
    public void editDistanceTest() {
        String word1 = "horse";
        String word2 = "ros";
        int result = minDistance(word1, word2);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 编辑距离最小步数
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 步数
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        // 定义数组
        int[][] dp = new int[n + 1][m + 1];
        // 初始化数组
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        // 状态转移方程
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[n][m];
    }

    /**
     * 编辑距离最小步数(动态规划)
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 步数
     */
    public int minDistance2(String word1, String word2) {
        if (word1 == null || word1.length() < 1) {
            return 0;
        }
        if (word2 == null || word2.length() < 1) {
            return 0;
        }
        int n = word1.length();
        int m = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        // dp[i][j]表示w1[0~i-1](⻓度为i⼦串)和w2[0~j-1](⻓度为j的⼦串)的最⼩编辑距离
        // 定义数组
        int[][] dp = new int[n + 1][m + 1];
        // 初始化数组
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        // 状态转移方程
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = min3(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = min3(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 获取三个数的最小值
     *
     * @param n1 数值n1
     * @param n2 数值n2
     * @param n3 数值n3
     * @return 最小数
     */
    private int min3(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }
}
