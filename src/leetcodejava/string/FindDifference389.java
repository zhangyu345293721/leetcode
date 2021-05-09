package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 389 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-the-difference
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindDifference389 {

    @Test
    public void findDifferenceTest() {
        char ch = findTheDifference2("abcd", "abcde");
        System.out.println(ch);
        Assert.assertEquals(ch, 'e');
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
