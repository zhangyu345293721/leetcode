package leetcodejava.tree;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.820 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/short-encoding-of-words
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *  
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ShortEncodingWords820 {

    @Test
    public void testShortEncodingWords() {
        String[] words = {"time", "me", "bell","ti"};
        int i = minimumLengthEncoding(words);
        System.out.println(i);
    }

    /**
     * 压缩字符串存储
     *
     * @param words 单词
     * @return 压缩长度
     */
    public int minimumLengthEncoding(String[] words) {
        StringBuffer sb = new StringBuffer();
        Arrays.sort(words,(a,b)->b.length()-a.length());
        for (String str : words) {
            if (!sb.toString().contains(str+"#")) {
                sb.append(str).append("#");
            }
        }
        return sb.toString().length();
    }

    /**
     * 压缩字符串存储
     *
     * @param words 单词
     * @return 压缩长度
     */
    public int minimumLengthEncoding2(String[] words) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                stringSet.remove(word.substring(i));
            }
        }
        int result = 0;
        for (String word : stringSet) {
            result += word.length() + 1;
        }
        return result;
    }

    /**
     * 压缩字符串存储
     *
     * @param words 单词
     * @return 压缩长度
     */
    public int minimumLengthEncoding3(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }
}
