package leetcodejava.string;


import org.junit.Test;

/**
 * 找出最大公共字符串
 *
 * @author: zhangyu
 */
public class GreatestCommon1071 {

    @Test
    public void greatestCommonTestDemo() {
        String str1 = "ABCABC";
        String str2 = "ABC";
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
        String shortStr = null;
        String longStr = null;
        if (str1.length() > str2.length()) {
            shortStr = str2;
            longStr = str1;
        } else {
            shortStr = str1;
            longStr = str2;
        }
        String temp = "";
        int end = shortStr.length();
        for (int i = 1; i <= end; i++) {
            String sub = shortStr.substring(0, i);
            int count1 = shortStr.length() / sub.length();
            int count2 = longStr.length() / sub.length();
            boolean flag1 = isDevide(sub, count1, shortStr);
            boolean flag2 = isDevide(sub, count2, longStr);
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
    private boolean isDevide(String sub, int count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(sub);
        }
        return sb.toString().equals(str);
    }
}
