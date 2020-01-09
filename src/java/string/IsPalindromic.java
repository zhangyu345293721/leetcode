package java.string;

import org.junit.Test;

import java.util.List;

/**
 * 判断是不是回文串，用StringBuilder的形式
 *
 * @author zhangyu
 **/


public class IsPalindromic {

    @Test
    public void testGroupAnagrams() {
        String str = "eat";
        boolean flag = isPalindromicString1(str);
        System.out.println(flag);
    }

    /**
     * @param subString 下标
     * @return 布尔值
     */
    public static boolean isPalindromicString1(String subString) {
        StringBuilder sb = new StringBuilder(subString);
        return subString.equals(sb.reverse().toString());
    }

    /**
     * 判断是不是回文串用双指针的形式
     *
     * @param subString 子字符串
     * @return 布尔值
     */
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

    /**
     * 判断是不是回文串用双指针的形式
     *
     * @param list 链表
     * @return
     */
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
