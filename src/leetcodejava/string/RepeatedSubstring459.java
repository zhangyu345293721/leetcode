package leetcodejava.string;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the solution of No.680 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/repeated-substring-pattern
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RepeatedSubstring459 {
    @Test
    public void repeatedSubstring() {
        String s = "bb";
        boolean flag = repeatedSubstringPattern3(s);
        System.out.println(flag);
    }

    /**
     * 计算字符串是否是重复的子字符串
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        boolean flag = false;
        int end = s.length() / 2;
        for (int i = 1; i <= end; i++) {
            String sub = s.substring(0, i);
            int count = s.length() / sub.length();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++) {
                sb.append(sub);
            }
            if (sb.toString().equals(s)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 判断是否是重复子字符串
     *
     * @param s 主字符串
     * @return 返回布尔值
     */
    public boolean repeatedSubstringPattern2(String s) {
        List<String> subStrList = getSubStrList(s);
        boolean flag = false;
        for (String str : subStrList) {
            if (isDivide(str, s)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 判断是否是重复子字符串
     *
     * @param s 主字符串
     * @return 返回布尔值
     */
    public boolean repeatedSubstringPattern3(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * 判断字符串是否被整除
     *
     * @param str 分割字符串
     * @param s   主字符串
     * @return 返回布尔值
     */
    private boolean isDivide(String str, String s) {
        String[] strings = s.split(str);
        String result = Arrays.asList(strings).stream().collect(Collectors.joining(""));
        return result.isEmpty();
    }

    /**
     * 获取所有的子串
     *
     * @param s 主字符串
     * @return 返回所有的字符串
     */
    private List<String> getSubStrList(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            list.add(s.substring(0, i));
        }
        return list;
    }
}
