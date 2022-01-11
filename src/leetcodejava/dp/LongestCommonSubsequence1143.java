package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.518 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-common-subsequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *  
 * 提示：
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestCommonSubsequence1143 {
    @Test
    public void longestCommonSubsequenceTest() {
        String s1 = "abcd";
        String s2 = "abc";
        int result = longestCommonSubsequence(s1, s2);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 最长相同序列
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 字符串3
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() < 1) {
            return 0;
        }
        if (text2 == null || text2.length() < 1) {
            return 0;
        }
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        // 定义数组
        // dp[i][j] 表示text1[0~i-1](⻓度为i⼦串)和text2[0~j-1](⻓度j的⼦串)的LCS
        int dp[][] = new int[n + 1][m + 1];
        // 初始化数组
        for (int j = 0; j <= m; ++j) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 0;
        }
        // 状态转移方程
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = max3(dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = max3(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 找到最大值
     *
     * @param a 数值a
     * @param b 数值b
     * @param c 数值c
     * @return 最大值
     */
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
