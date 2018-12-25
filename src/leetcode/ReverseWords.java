package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ReverseWords
 * @Description: TOTO
 * @date 2018/11/30 14:30
 **/


public class ReverseWords {
    @Test
    public void fun() {
        String s = "we are from china";
        String newString = reverseString(s);
        System.out.println(newString);
    }

    private String reverseString(String s) {
        String[] strs = s.split(" +");
        StringBuilder sb = new StringBuilder();

        for (String ss : strs) {
            sb.append(new StringBuilder(ss).reverse()+" ");
        }
        return sb.toString().trim();
    }
}
