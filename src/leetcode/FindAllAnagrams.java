package leetcode;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: FindAllAnagrams
 * @Description: TOTO
 * @date 2018/12/5 17:22
 **/


public class FindAllAnagrams {
    @Test
    public void fun() {
        String s = "baa";
        String p = "aa";
        List<Integer> list= findAllAnagrams(s, p);
        System.out.println(list);
    }

    private List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = p.length();
        while (j <= s.length()) {
            String subString = s.substring(i, j);
            if (equalsIgnoreOrderString1(subString, p)) {
                list.add(i);
            }
            i++;
            j++;
        }
        //return Arrays.copyOfRange(indexs,0,count);
        return list;
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
                s=s.replaceFirst(String.valueOf(ch), "@");
            } else {
                return false;
            }
        }
        return true;
    }
}
