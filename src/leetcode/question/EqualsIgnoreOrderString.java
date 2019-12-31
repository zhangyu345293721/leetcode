package leetcode.question;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 **/


public class EqualsIgnoreOrderString {
    @Test
    public void fun() {
        String s = "aaaaa";
        String p = "aa";
        boolean b = equalsIgnoreOrderString1(s, p);
        System.out.println(b);
    }

    /**
     * 忽略大小字符串
     *
     * @param s 字符串s
     * @param p 字符串p
     * @return 布尔
     */
    public boolean equalsIgnoreOrderString1(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        if (s.length() != p.length()) {
            return false;
        }
        char[] chsp = p.toCharArray();
        for (char ch : chsp) {
            if (s.contains(String.valueOf(ch))) {
                s = s.replaceFirst(String.valueOf(ch), "@");
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 忽略大小字符串
     *
     * @param s 字符串s
     * @param p 字符串p
     * @return 布尔
     */
    public boolean equalsIgnoreOrderString2(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        if (s.length() != p.length()) {
            return false;
        }
        char[] chsp = p.toCharArray();
        char[] chss = s.toCharArray();
        Arrays.sort(chsp);
        Arrays.sort(chss);
        return new String(chsp).equals(new String(chss));
    }
}
