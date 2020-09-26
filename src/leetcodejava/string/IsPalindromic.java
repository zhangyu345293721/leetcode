package leetcodejava.string;

import org.junit.Test;

/**
 * 判断是不是回文串
 *
 * @author zhangyu
 **/


public class IsPalindromic {

    @Test
    public void groupAnagramsTest() {
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
}
