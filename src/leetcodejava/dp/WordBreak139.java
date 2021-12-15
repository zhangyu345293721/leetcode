package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 139 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-break/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class WordBreak139 {
    @Test
    public void wordBreakTest() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean result = wordBreak2(s, wordDict);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 单词拆分,动态规划
     *
     * @param s        字符串
     * @param wordDict 单词字典
     * @return 布尔值
     */
    private boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] b = new boolean[s.length() + 1];
        b[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (b[i] && wordDict.contains(s.substring(i, j))) {
                    b[j] = true;
                }
            }
        }
        return b[length];
    }

    /**
     * 单词拆分,动态规划
     *
     * @param s        字符串
     * @param wordDict 单词字典
     * @return 布尔值
     */
    private boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    /**
     * 单词拆分,动态规划
     *
     * @param s        字符串
     * @param wordDict 单词字典
     * @return 布尔值
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() < 1) {
            return false;
        }
        int n = s.length();
        // dp[i]表示⻓度为i的字符串是可拆分的
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) { //i表示⻓度
            for (String word : wordDict) { //⾛法
                int len = word.length();
                int start = i - len;
                if (start >= 0 && s.startsWith(word, start) && dp[i - len]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
