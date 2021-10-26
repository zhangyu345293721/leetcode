package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.521 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
 * <p>
 * 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
 * 示例 2：
 * <p>
 * 输入：a = "aaa", b = "bbb"
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：a = "aaa", b = "aaa"
 * 输出：-1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestUncommonSubsequence521 {

    @Test
    public void longestUncommonSubsequenceTest() {
        String a = "aaa";
        String b = "bbn";
        int result = findLUSlength(a, b);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 找出最大字符串
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return 长度
     */
    public int findLUSlength(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(alen, blen);
    }
}
