package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 0102 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-strings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CheckPermutationLCCI0102 {


    @Test
    public void checkPermutationTest() {
        String s1 = "abc", s2 = "bca";
        boolean result = checkPermutation(s1, s2);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 判断是否可以由一个字符串变成另外一个字符串
     *
     * @param s1 字符串s1
     * @param s2 字符串s2
     * @return 布尔值
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s1.length() < 1) {
            return false;
        }
        if (s2 == null || s2.length() < 1) {
            return false;
        }
        int[] map = new int[128];
        for (char ch : s1.toCharArray()) {
            map[ch]++;
        }
        for (char ch : s2.toCharArray()) {
            map[ch]--;
        }
        for (int num : map) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
