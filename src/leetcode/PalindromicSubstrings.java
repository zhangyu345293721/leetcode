package leetcode;

import org.junit.Test;

/**
 * 这种是暴力破解算法，在一般的情况下，是非常有效，而且不会容易出错，当在大字符串时候，就会出现效率问题
 *
 * @author zhangyu
 **/


public class PalindromicSubstrings {
    @Test
    public void fun() {
        // String s = "abc";
        String s = "aaa";
        int number = palindromicSubstrings(s);
        System.out.println(number);
    }


    /**
     * 找出一个字符串中有多少个回文串
     * @param s 字符串
     * @return 个数
     */
    private int palindromicSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindromic2(subString)) {
                    count++;
                    System.out.println(subString);
                }
            }
        }
        return count;
    }

    // 判断一个字符串是不是回文串
    public static boolean isPalindromic2(String subString) {
        int i = 0;
        int j = subString.length() - 1;
        while (i < j) {
            if (subString.charAt(i) != subString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 统计所有的回文串个数
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文串可能是双数，可能是单数
            count += computePalin(s, i, i);
            count += computePalin(s, i, i + 1);
        }
        return count;
    }

    // 查找两个下标下的元素回文串个数
    private int computePalin(String s, int i, int j) {
        int result = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            result++;
        }
        return result;
    }
}
