package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is the solution of No.290 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-pattern
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class WordPattern290 {

    @Test
    public void wordPatternTest() {
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean result = wordPattern(pattern, str);
        Assert.assertEquals(result, true);
    }

    /**
     * 判断单词是否和模式串匹配
     *
     * @param pattern 模式串
     * @param s       匹配串
     * @return 布尔值
     */
    public boolean wordPattern(String pattern, String s) {
        if ("".equals(pattern.trim()) || "".equals(s.trim())) {
            return false;
        }
        String[] words = s.trim().split(" ");
        Map<Character, String> map = new HashMap<>();
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(ch)) {
                String oldWord = map.get(ch);
                if (!oldWord.equals(word)) {
                    return false;
                }
            } else {
                map.put(ch, word);
            }
        }
        return map.keySet().size() == new HashSet<>(map.values()).size();
    }

    /**
     * 判断单词是否和模式串匹配
     *
     * @param pattern 模式串
     * @param s       匹配串
     * @return 布尔值
     */
    public boolean wordPattern2(String pattern, String s) {
        if ("".equals(pattern.trim()) || "".equals(s.trim())) {
            return false;
        }
        String[] map = new String[26];
        Set<String> set = new HashSet<>();
        int i = 0;
        int j = 0;
        for (; i < pattern.length(); i++, j++) {
            int c = pattern.charAt(i) - 'a';
            int k = j;
            while (j < s.length() && s.charAt(j) != ' ') {
                ++j;
            }
            if (j == k) {
                return false;
            }
            String w = s.substring(k, j);
            if (map[c] == null && !set.contains(w)) {
                set.add(w);
                map[c] = w;
                continue;
            } else if (map[c] != null && map[c].equals(w)) {
                continue;
            }
            return false;
        }
        return i == pattern.length() && j >= s.length();
    }
}
