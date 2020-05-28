package leetcodejava.math;


import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.890 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-and-replace-pattern
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 *
 * 示例：
 *
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReplacePattern890 {

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

    /**
     * 找出规律串链表
     *
     * @param words   输入单词数组
     * @param pattern 匹配模式串
     * @return 返回匹配相似链表（不能直接返回空，否则很容易出现NonePointerExcception）
     */
    public List<String> findAndReplacePattern2(String[] words, String pattern) {
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
