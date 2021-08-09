package leetcodejava.tree;

import java.util.HashMap;

/**
 * 定义一个trie树
 *
 * @author: zhangyu
 * @date: 2021/7/14
 */
public class Trie {
    /**
     * Trie树的孩子节点
     */
    public HashMap<Character, Trie> children = new HashMap<>();
    /**
     * 是否是结束
     */
    public boolean isEnd = false;
    /**
     * 单词的值
     */
    public String val = null;
}
