package leetcode.select;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到相同特征的字符串
 *
 * @author: zhangyu
 */
public class ReplacePattern8902 {

    @Test
    public void replacePatternTestDemo() {
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
     * @return 返回匹配相似链表（不能直接返回空，否则很容易出现NonePointerExcception）
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || words.length < 1 || pattern == null || pattern.length() < 1) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isPattern(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    /**
     * 判断匹配字符和模式串是不是匹配
     *
     * @param str     匹配字符串
     * @param pattern 模式串
     * @return 布尔值
     */
    private boolean isPattern(String str, String pattern) {
        if (str.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charStr = str.charAt(i);
            char charPattern = pattern.charAt(i);
            if (!map.containsKey(charPattern) && !map.containsValue(charStr)) {
                map.put(charPattern, charStr);
                sb.append(charStr);
            } else {
                sb.append(map.get(charPattern));
            }
        }
        return sb.toString().equals(str);
    }
}
