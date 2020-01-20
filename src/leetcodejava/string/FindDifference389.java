package leetcodejava.string;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出两个字符串中不同的部分
 *
 * @author: zhangyu
 */
public class FindDifference389 {

    @Test
    public void testFindDifference() {
        char ch = findTheDifference2("abcd", "abcde");
        System.out.println(ch);
    }

    /**
     * 找出字符串不通
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 字符
     */
    public char findTheDifference(String s, String t) {
        char ch = 0;
        for (char ch1 : s.toCharArray()) {
            ch ^= ch1;
        }
        for (char ch2 : t.toCharArray()) {
            ch ^= ch2;
        }
        return ch;
    }


    /**
     * 找出字符串不通
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 字符
     */
    public char findTheDifference2(String s, String t) {
        Set<Character> set = new HashSet<>();
        for (char ch1 : s.toCharArray()) {
            if (set.contains(ch1)) {
                set.remove(ch1);
            } else {
                set.add(ch1);
            }
        }
        for (char ch2 : t.toCharArray()) {
            if (set.contains(ch2)) {
                set.remove(ch2);
            } else {
                set.add(ch2);
            }
        }
        return set.stream().findFirst().get();
    }
}
