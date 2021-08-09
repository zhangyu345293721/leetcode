package leetcodejava.string;

import leetcodejava.tree.Trie;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No.720 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-word-in-dictionary
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * 示例 1：
 * <p>
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestWordDictionary720 {

    @Test
    public void longestWordDictionaryTest() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        String result = longestWord2(words);
        System.out.println(result);
        Assert.assertEquals(result, "world");
    }

    /**
     * 最长的单词
     *
     * @param words 单词数组
     * @return 单词字符串
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            // 如果单词只有一个字母，那一定是共有的
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }

    /**
     * 最长的单词
     *
     * @param words 单词数组
     * @return 单词字符串
     */
    public String longestWord2(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Trie root = new Trie();
        for (String w : words) {
            Trie cur = root;
            for (char c : w.toCharArray()) {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    Trie newNode = new Trie();
                    cur.children.put(c, newNode);
                    cur = newNode;
                }
            }
            cur.val = w;
            cur.isEnd = true;
        }
        String result = "";
        for (String w : words) {
            Trie cur = root;
            if (w.length() > result.length() || (w.length() == result.length() && w.compareTo(result) < 0)) {
                boolean isWord = true;
                for (char c : w.toCharArray()) {
                    cur = cur.children.get(c);
                    if (!cur.isEnd) {
                        isWord = false;
                        break;
                    }
                }
                result = isWord ? w : result;
            }
        }
        return result;
    }
}
