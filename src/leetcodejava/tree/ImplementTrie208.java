package leetcodejava.tree;

import org.junit.Test;

import java.util.TreeMap;

/**
 * This is the solution of No. 208 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-word-in-dictionary
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * <p>
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

public class ImplementTrie208 {

    @Test
    public void implementTrieTest() {
        ImplementTrie208 trie = new ImplementTrie208();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app");       // 返回 true
        trie.insert("app");     // 返回 void
        trie.search("app");     // 返回 true
    }

    /**
     * 构造root节点
     */
    private TrieNode root;

    /**
     * 构造trie树方法
     */
    public ImplementTrie208() {
        root = new TrieNode();
    }

    /**
     * 向Trie中添加单词
     * 时间复杂度：O(m), m为要查询字符串的长度
     * 空间复杂度：O(m), 最坏情况下没有公共节点，需要添加 m 个节点
     *
     * @param word 插入单词
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * 判断单词是否在 Trie 中
     * 时间复杂度：O(m), m为要查询字符串的长度
     * 空间复杂度：O(1)
     *
     * @param word 查找单词
     * @return 布尔值
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * 时间复杂度：O(m), m为要查询字符串的长度
     * 空间复杂度：O(1)
     *
     * @param prefix 前缀字符串
     * @return 布尔值
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}

class TrieNode {
    /**
     * 是否为单词的标志位
     */
    public boolean isWord;
    /**
     * 存储单词穿的map
     */
    public TreeMap<Character, TrieNode> next;

    /**
     * 构造node节点的构造方法
     *
     * @param isWord 是否是word标志位
     */
    public TrieNode(boolean isWord) {
        this.isWord = isWord;
        next = new TreeMap<>();
    }

    /**
     * 构造node节点的方法
     */
    public TrieNode() {
        this(false);
    }
}

