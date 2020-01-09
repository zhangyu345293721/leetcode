package leetcodejava.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * wordbreak
 *
 * @author zhangyu
 **/


public class WordBreak139 {
    @Test
    public void testWordBreak() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean flag = wordBreak2(s, wordDict);
        System.out.println(flag);
    }


    /**
     * 单词拆分
     *
     * @param s        字符串
     * @param wordDict 单词字典
     * @return
     */
    private boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
