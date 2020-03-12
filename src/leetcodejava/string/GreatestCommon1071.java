package leetcodejava.string;


import org.junit.Test;

/**
 * This is the solution of No. 1071 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Note:
 * - 1 <= str1.length <= 1000
 * - 1 <= str2.length <= 1000
 * - str1[i] and str2[i] are English uppercase letters.
 * ==========================================================================================================
 *
 * @author  zhangyu (zhangyuyu417@gmail.com)
 */
public class GreatestCommon1071 {

    @Test
    public void testGreatestCommon() {
        String str1 = "LEET";
        String str2 = "CODe";
        String maxString = gcdOfStrings(str1, str2);
        System.out.println("maxString = " + maxString);
    }

    /**
     * 找出两个字符串的最大公共子串
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最大公共子串
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str1.length() < 1) {
            return "";
        }
        if (str2 == null || str2.length() < 1) {
            return "";
        }
        if (str2.equals(str1)) {
            return str1;
        }
        String temp = "";
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        int end = str2.length();
        for (int i = 1; i <= end; i++) {
            String sub = str2.substring(0, i);
            int count1 = str2.length() / sub.length();
            int count2 = str1.length() / sub.length();
            boolean flag1 = isDivide(sub, count1, str2);
            boolean flag2 = isDivide(sub, count2, str1);
            if (flag1 && flag2) {
                temp = sub;
            }
        }
        return temp;
    }
    /**
     * 判断是否被整除
     *
     * @param sub   子字符串
     * @param count 循环次数
     * @param str   要比较的字符串
     * @return 布尔值
     */
    private boolean isDivide(String sub, int count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(sub);
        }
        return sb.toString().equals(str);
    }

    /**
     * 找出两个字符串的最大公共子串
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最大公共子串
     */
    public String gcdOfStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str2.substring(0, findMaxIndex(str1.length(), str2.length()));
    }

    /**
     * 找出两个数最大公约数
     *
     * @param a 数字a
     * @param b 数字b
     * @return 数字
     */
    private int findMaxIndex(int a, int b) {
        int num = Math.max(a, b);
        int max = 1;
        for (int i = 2; i <= num; i++) {
            if (a % i == 0 && b % i == 0) {
                max = Math.max(i, max);
            }
        }
        return max;
    }
}
