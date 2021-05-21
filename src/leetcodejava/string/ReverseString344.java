package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.344 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseString344 {

    @Test
    public void reverseStringTest() {
        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        reverseString2(chs);
        System.out.println(Arrays.toString(chs));
        Assert.assertArrayEquals(chs, new char[]{'o', 'l', 'l', 'e', 'h'});
    }

    /**
     * 倒转字符串数组
     *
     * @param s 字符数组
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    /**
     * 倒转字符串数组
     *
     * @param s 字符数组
     */
    public void reverseString2(char[] s) {
        if (s == null || s.length < 1) {
            return;
        }
        reverseRecursion(s, 0, s.length - 1);
        return;
    }

    /**
     * 反转字符粗
     *
     * @param s     字符串s
     * @param left  left位置
     * @param right right位置
     */
    private void reverseRecursion(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        reverseRecursion(s, left + 1, right - 1);
        swap(s, left, right);
    }

    /**
     * 交换数组中两个字符的位置
     *
     * @param s 数组
     * @param i   位置i
     * @param j   位置j
     */
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
