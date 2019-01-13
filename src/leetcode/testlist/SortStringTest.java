package leetcode.testlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SortStringTest
 * @Description: TOTO
 * @date 2018/11/14 19:41
 **/


public class SortStringTest {
    @Test
    public void fun() {
        String s1 = "bac";
        String s2 = "cba";
        String newString = sortString(s1);
        String newString2 = sortString(s2);
        System.out.println(newString);
        System.out.println(newString2);
    }

    public String sortString(String s) {
        char chs[] = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}
