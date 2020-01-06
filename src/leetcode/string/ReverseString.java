package leetcode.string;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 按照要求反转字符串
 */
public class ReverseString {

    @Test
    public void fun() {
        String s = "abcdefg";
        String s1 = getReverseString(s, 2);
        System.out.println(s1);
    }

    /**
     * 一个字符串按照要求返回
     *
     * @param str 字符串
     * @param n   位置
     * @return 返回字符串
     */
    public String getReverseString(String str, int n) {
        List<String> list = getStringList(str, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if ((i & 1) == 0) {
                sb.append(new StringBuffer(list.get(i)).reverse().toString());
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    private ArrayList<String> getStringList(String str, int n) {
        ArrayList<String> list = new ArrayList<String>();
        String regEx = "\\w{" + n + "}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        if (n * (list.size()) < str.length()) {
            list.add(str.substring(n * list.size()));
        }
        return list;
    }
}
