package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 按照要求反转字符串
 *
 * @author: zhangyu
 */
public class ReverseString541 {

    @Test
    public void testReverseString541() {
        String s = "abcdefg";
        int key = 2;
        String result = getReverseString(s, key);
        System.out.println(result);
    }

    /**
     * 翻转字符串
     *
     * @param s 字符串s
     * @param k k
     * @return 字符串
     */
    private String getReverseString(String s, int k) {
        if (s.length() <= k) {
            return new StringBuffer(s).reverse().toString();
        }
        if (s.length() > k && s.length() <= 2 * k) {
            String subString = s.substring(0, k);
            subString = new StringBuffer(subString).reverse().toString();
            return subString + s.substring(k);
        }
        if (s.length() > 2 * k) {
            LinkedList<String> list = new LinkedList<>();
            StringBuffer sb = new StringBuffer();
            int number = s.length() / k;
            for (int i = 0; i < number; i++) {
                list.add(s.substring(i * k, i * k + k));
            }
            if (number * k < s.length()) {
                list.add(s.substring(number * k));
            }
            for (int index = 0; index < list.size(); index++) {
                if (index % 2 == 0) {
                    String temp = new StringBuffer(list.get(index)).reverse().toString();
                    sb.append(temp);
                } else {
                    sb.append(list.get(index));
                }
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 翻转字符串
     *
     * @param s 字符串s
     * @param k k
     * @return 字符串
     */
    public String reverseStr2(String s, int k) {
        LinkedList<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        int number = s.length() / k;
        for (int i = 0; i < number; i++) {
            list.add(s.substring(i * k, i * k + k));
        }
        if (number * k < s.length()) {
            list.add(s.substring(number * k));
        }
        for (int index = 0; index < list.size(); index++) {
            if (index % 2 == 0) {
                String temp = new StringBuffer(list.get(index)).reverse().toString();
                sb.append(temp);
            } else {
                sb.append(list.get(index));
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

    /**
     * 翻转字符串
     *
     * @param s 字符串s
     * @param k k
     * @return 字符串
     */
    public String getReverseString3(List<String> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                sb.append(new StringBuffer(list.get(i)).reverse().toString());
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
