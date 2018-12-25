import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: WrodBreak
 * @Description: TOTO
 * @date 2018/12/13 13:53
 **/


public class WordBreak {
    @Test
    public void fun() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean flag = wordBreak2(s, wordDict);
        System.out.println(flag);
    }

    // 这个有问题
    /*private boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.contains(word)) {
                // int index = s.indexOf(word);
                //  s = s.substring(index, index + word.length());
                s = s.replaceFirst(word, "");
            }
        }
        if (s.equals("") || wordDict.contains(s)) {
            return true;
        }
        return false;
    }*/

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
