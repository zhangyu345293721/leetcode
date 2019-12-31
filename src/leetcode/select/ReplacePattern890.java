package leetcode.select;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找到相同特征的字符串
 *
 * @author: zhangyu
 */
public class ReplacePattern890 {

    @Test
    public void replacePatternTestDemo() {
        /*String[] words = {"abc", "cba", "xyx", "yxx", "yyx"};
        String pattern = "abc";*/

        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> patternStrs = findAndReplacePattern(words, pattern);
        System.out.println("patternStrs = " + patternStrs);
    }

    /**
     * 找出规律串链表
     *
     * @param words   输入单词数组
     * @param pattern 匹配模式串
     * @return 返回匹配相似链表
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String patternStr = getFigureStr(pattern);
        List<String> matchList = new ArrayList<>();
        for (String str : words) {
            String matchStr = getFigureStr(str);
            if (matchStr.equals(patternStr) && getUniqueSize(str) == getUniqueSize(pattern)) {
                matchList.add(str);
            }
        }
        return matchList;
    }

    /**
     * 获取模式串的规律
     *
     * @param pattern 输入模式串
     * @return 返回规律串
     */
    private String getFigureStr(String pattern) {
        StringBuilder sb = new StringBuilder();
        char[] chs = pattern.toCharArray();
        int count = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == chs[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            sb.append(count);
        }
        return sb.toString();
    }

    /**
     * @param str 输入字符串
     * @return 返回字符串不相同格式
     */
    public int getUniqueSize(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        return set.size();
    }
}
