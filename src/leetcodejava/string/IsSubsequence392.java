package leetcodejava.string;

import org.junit.Test;

/**
 * This is the solution of No. 392 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/is-subsequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class IsSubsequence392 {

    @Test
    public void IsSubsequenceTest() {
        String s = "abc";
        String t = "ahbgdc";
        boolean result = isSubsequence2(s, t);
        System.out.println(result);
    }

    /**
     * 判断子序列
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 布尔值
     */
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char ch = s.charAt(i);
            if (t.contains(String.valueOf(ch))) {
                int j = t.indexOf(ch);
                t = t.substring(j + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断子序列
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 布尔值
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 判断子序列
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 布尔值
     */
    public boolean isSubsequence3(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
