package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串进行排序，并判断是否能够组合成
 * 利用map
 *
 * @author: zhangyu
 */
public class FindWordsCanFormedCharacters1160 {

    @Test
    public void testFindWords() {
        String[] words = {"hello", "world", "java"};
        String chars = "welldonehoneyr";
        int total = countCharacters2(words, chars);
        System.out.println(total);
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
