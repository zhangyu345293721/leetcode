package leetcode.question;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: EqualsIgnoreOrderString
 * @Description: TOTO
 * @date 2018/11/20 18:35
 **/


public class EqualsIgnoreOrderString {
    @Test
    public void fun() {
        String s = "aaaaa";
        String p = "aa";
        boolean b = equalsIgnoreOrderString1(s, p);
        System.out.println(b);
    }

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
