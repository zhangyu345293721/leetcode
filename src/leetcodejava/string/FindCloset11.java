package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 17.11 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-closest-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindCloset11 {

    @Test
    public void findClosetTest() {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "student";
        int result = findClosest(words, word1, word2);
        System.out.println(result);
        Assert.assertEquals(result, 1);
    }

    /**
     * 查找最近单词
     *
     * @param words 单词数组
     * @param word1 单词1
     * @param word2 单词2
     * @return 单词最短距离
     */
    public int findClosest(String[] words, String word1, String word2) {
        if (words == null || words.length < 1) {
            return 0;
        }
        List<Integer> wordList1 = new ArrayList<>();
        List<Integer> wordList2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                wordList1.add(i);
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (word2.equals(words[i])) {
                wordList2.add(i);
            }
        }
        int length1 = wordList1.size();
        int length2 = wordList2.size();
        int i = 0;
        int j = 0;
        int closetValue = Integer.MAX_VALUE;
        while (i < length1 && j < length2) {
            int num1 = wordList1.get(i);
            int num2 = wordList2.get(j);
            if (num1 < num2) {
                closetValue = Math.min(Math.abs(num1 - num2), closetValue);
                i++;
            } else {
                closetValue = Math.min(Math.abs(num1 - num2), closetValue);
                j++;
            }
        }
        return closetValue;
    }
}
