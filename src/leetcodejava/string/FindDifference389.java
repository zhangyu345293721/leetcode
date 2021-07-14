package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

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
        int total = 0;
        for (char c : t.toCharArray()) {
            total += c;
        }
        for (char c : s.toCharArray()) {
            total -= c;
        }
        return (char) total;
    }

    /**
     * 找出字符串不通(数组字典形式)
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 字符
     */
    public char findTheDifference3(String s, String t) {
        int[] chs = new int[26];
        for (char ch : t.toCharArray()) {
            chs[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            chs[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s.charAt(i) > 0) {
                return (char) (i + 'a');
            }
        }
        return '0';
    }
}
