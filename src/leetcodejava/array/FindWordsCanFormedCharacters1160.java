package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 1160 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindWordsCanFormedCharacters1160 {

    @Test
    public void testFindWords() {
        String[] words = {"hello", "world", "java"};
        String chars = "welldonehoneyr";
        int total = countCharacters2(words, chars);
        Assert.assertEquals(total, 10);
    }

    /**
     * 计算拼成字符串长度
     *
     * @param words 单词数组
     * @param chars 目标字符串
     * @return 长度
     */
    public int countCharacters(String[] words, String chars) {
        int totalLength = 0;
        Map<Character, Integer> charsMap = getDict(chars);
        for (String word : words) {
            Map<Character, Integer> wordMap = getDict(word);
            boolean flag = compareMap(charsMap, wordMap);
            if (flag) {
                totalLength += word.length();
            }
        }
        return totalLength;
    }

    /**
     * 比较两个map
     *
     * @param charsMap 比较字符串
     * @param wordMap  字符串
     * @return 布尔值
     */
    private boolean compareMap(Map<Character, Integer> charsMap, Map<Character, Integer> wordMap) {
        for (Map.Entry<Character, Integer> ch : wordMap.entrySet()) {
            if (!charsMap.containsKey(ch.getKey()) || ch.getValue() > charsMap.get(ch.getKey())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串统计字符串出现个数
     *
     * @param chars 字符串
     * @return map
     */
    private Map<Character, Integer> getDict(String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    /**
     * @param words 单词数组
     * @param chars 字符串
     * @return 个数
     */
    public int countCharacters2(String[] words, String chars) {
        int[] charCounts = new int[26];
        for (char c : chars.toCharArray()) {
            charCounts[c - 'a']++;
        }
        int totalLength = 0;
        for (String word : words) {
            if (canBeFormed(word, charCounts)) {
                totalLength += word.length();
            }
        }
        return totalLength;
    }

    /**
     * @param word       单词
     * @param charCounts 字符数组
     * @return 布尔值
     */
    private boolean canBeFormed(String word, int[] charCounts) {
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (++counts[idx] > charCounts[idx]) {
                return false;
            }
        }
        return true;
    }
}
