package leetcodejava.tree;

import org.junit.Test;

import java.util.*;

/**
 * 压缩字符串
 *
 * @author: zhangyu
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
