package leetcode;

import org.junit.Test;

/** 这种是暴力破解算法，在一般的情况下，是非常有效，而且不会容易出错，当在大字符串时候，就会出现效率问题
 * @author zhangyu
 * @version V1.0
 * @ClassName: PalindromicSubstrings
 * @Description: TOTO
 * @date 2018/12/5 20:35
 **/


public class PalindromicSubstrings {
    @Test
    public void fun() {
       // String s = "abc";
        String s="aaa";
        int number = palindromicSubstrings(s);
        System.out.println(number);
    }

    // 找出一个字符串中有多少个回文串
    private int palindromicSubstrings(String s) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if(isPalindromic2(subString)){
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
}
