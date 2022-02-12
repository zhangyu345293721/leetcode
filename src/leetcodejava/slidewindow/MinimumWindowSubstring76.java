package leetcodejava.slidewindow;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 76 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-window-substring
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumWindowSubstring76 {

    @Test
    public void minimumWindowSubstringTest() {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String result = minWindow3(s, t);
        System.out.println(result);
        Assert.assertEquals(result, "cwae");
    }
    /**
     * 最小窗口
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 最小包含子串
     */
    public String minWindow1(String s, String t) {
        if (t == null || t.length() < 1) {
            return "";
        }
        if (t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        int[] chs2 = getNums(t);
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subStr = s.substring(i, j);
                int[] chs1 = getNums(subStr);
                if (subStr.length() >= t.length() && checkLarge(chs1, chs2)) {
                    if (minLen > subStr.length()) {
                        minLen = subStr.length();
                        minStr = subStr;
                    }
                }
            }
        }
        return minStr;
    }

    /**
     * 检查该字符是否包含
     *
     * @param nums1 数字数组1
     * @param nums2 数字数组2
     * @return 布尔值
     */
    public boolean checkLarge(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < nums2[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 最小窗口(滑动窗口)
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 最小包含子串
     */
    public String minWindow2(String s, String t) {
        if (t == null || t.length() < 1) {
            return "";
        }
        if (t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        int[] chs2 = getNums(t);
        String minStr = s;
        int n = s.length();
        int right = 1;
        int left = 0;
        // 默认没有匹配的字符串
        boolean flag = false;
        while (right <= n) {
            String sub = s.substring(left, right);
            if (!checkLarge(getNums(sub), chs2)) {
                right++;
            } else {
                flag = true;
                if (minStr.length() > sub.length()) {
                    minStr = sub;
                }
                left++;
            }
        }
        // 没有匹配到
        return flag ? minStr : "";
    }

    /**
     * 最小窗口(滑动窗口)
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 最小包含子串
     */
    public String minWindow3(String s, String t) {
        if (t == null || t.length() < 1) {
            return "";
        }
        if (t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        int[] nums1 = new int[128];
        int[] nums2 = getNums(t);
        int len = s.length();
        int right = 0;
        int left = 0;
        int resLeft = 0;
        int resRight = 0;
        while (right < len) {
            if (!checkLarge(nums1, nums2)) {
                nums1[s.charAt(right) - 'A']++;
                right++;
            }
            while (checkLarge(nums1, nums2)) {
                if (len >= right - left) {
                    resLeft = left;
                    resRight = right;
                    // 更新len值
                    len = right - left;
                }
                nums1[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.substring(resLeft, resRight);
    }

    /**
     * 获取字符串
     *
     * @param str 字符串
     * @return 数组
     */
    public int[] getNums(String str) {
        if (str == null || str.length() < 1) {
            return new int[128];
        }
        int[] nums = new int[128];
        for (char ch : str.toCharArray()) {
            nums[ch - 'A']++;
        }
        return nums;
    }
}
