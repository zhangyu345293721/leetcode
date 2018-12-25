package leetcode;

import org.junit.Test;

/**
 * 找出一个字符串中所有的回文串个数，效率比较高的算法
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: PalindromicSubstrings
 * @Description: TOTO
 * @date 2018/12/5 20:35
 **/


public class PalindromicSubstrings2 {
    @Test
    public void fun() {
        // String s = "abc";
        String s = "aaa";
        int number = countSubstrings(s);
        System.out.println(number);
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
