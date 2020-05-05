package leetcodejava.string;


import org.junit.Test;

/**
 * This is the solution of No. 14 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-common-prefix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestCommon14 {

    @Test
    public void longestCommonTestDemo() {
        String[] strs = {"c", "c"};
        String longestStr = longestCommonPrefix(strs);
        System.out.println("longestStr = " + longestStr);
    }

    /**
     * 最长相同字符串
     *
     * @param strs 输入字符串
     * @return 返回最长相同字符串
     */
    public String longestCommonPrefix(String[] strs) {
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
}
