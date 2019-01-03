package leetcode;

import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: IsPalindromic
 * @Description: TOTO
 * @date 2018/12/5 20:51
 **/


public class IsPalindromic {
    //1.判断是不是回文串，用StringBuilder的形式
    public static boolean isPalindromicString1(String subString) {
        StringBuilder sb = new StringBuilder(subString);
        return subString.equals(sb.reverse().toString());
    }

    //2.判断是不是回文串用双指针的形式
    public static boolean isPalindromicString2(String subString) {
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

    public boolean isPalindromeList(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;
    }
}
