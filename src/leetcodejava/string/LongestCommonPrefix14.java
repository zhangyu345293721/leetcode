package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 14 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-common-prefix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestCommonPrefix14 {

    @Test
    public void longestCommonTest() {
        String[] strs = {"c", "ceee"};
        String result = longestCommonPrefix1(strs);
        System.out.println(result);
        Assert.assertEquals(result, "c");
    }

    /**
     * 最长相同字符串
     *
     * @param strs 输入字符串
     * @return 返回最长相同字符串
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length < 2) {
            return strs[0];
        }
        String longestStr = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            String sub = strs[0].substring(0, i);
            boolean flag = isAllMatch(sub, strs);
            if (flag) {
                longestStr = sub;
            } else {
                return longestStr;
            }
        }
        return longestStr;
    }

    /**
     * 是否全部匹配
     *
     * @param sub  输入子串
     * @param strs 总的字符串
     * @return 返回布尔值
     */
    private boolean isAllMatch(String sub, String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(sub)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 找出最长前缀子串
     *
     * @param strs 字符串
     * @return 最长子字符串
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        for (int i = 0; i < minLen; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }


    /**
     * 找出最长前缀子串
     *
     * @param strs 字符串
     * @return 最长子字符串
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 找出最长前缀子串
     *
     * @param strs 字符串
     * @return 最长子字符串
     */
    private String longestCommonPrefix4(String[] strs, int si, int ei) {
        if (si == ei) {
            return strs[si];
        }
        int mi = si + ((ei - si) >> 1);
        String left = longestCommonPrefix4(strs, si, mi);
        String right = longestCommonPrefix4(strs, mi + 1, ei);
        return commonPrefix(left, right);
    }

    /**
     * 找出相同前缀
     *
     * @param s1 s1字符串
     * @param s2 s2字符串
     * @return 相同字符串
     */
    public String commonPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLen);
    }
}
