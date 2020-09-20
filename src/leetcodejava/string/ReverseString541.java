package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg" 
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseString541 {

    @Test
    public void reverseStringTest() {
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
