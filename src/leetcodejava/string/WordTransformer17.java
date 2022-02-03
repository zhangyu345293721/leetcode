package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 17 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindromic-substrings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能
 * 在字典中找到。编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 通过次数9,434提交次数24,882
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-transformer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class WordTransformer17 {

    @Test
    public void wordTransformerTest() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> result = findLadders(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList)));
        System.out.println(result);
        Assert.assertEquals(result.get(0), "hit");

    }

    /**
     * 查找是否能变成数据
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  单词表
     * @return 结果集合
     */
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 1) {
            return new ArrayList<>();
        }
        List<String> result = new LinkedList<>(Arrays.asList(beginWord));
        boolean[] visited = new boolean[wordList.size()];
        if (searchHelper(beginWord, endWord, result, wordList, visited)) {
            return result;
        }
        return new ArrayList<>();
    }

    /**
     * 深度优先遍历
     *
     * @param cur      当前字符串
     * @param result   结果字符
     * @param wordList 单词表
     * @param visited  是否访问过
     * @return 布尔值
     */
    public boolean searchHelper(String cur, String endWord, List<String> result, List<String> wordList, boolean[] visited) {
        if (cur.equals(endWord)) {
            return true;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && adj(cur, wordList.get(i))) {
                visited[i] = true;
                result.add(wordList.get(i));
                if (searchHelper(wordList.get(i), endWord, result, wordList, visited)) {
                    return true;
                }
                // 回退操作
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    /**
     * 判断两个字符串是否是相邻
     *
     * @param s 字符串s
     * @param p 字符串p
     * @return 布尔值
     */
    public boolean adj(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return 1 == count;
    }
}
