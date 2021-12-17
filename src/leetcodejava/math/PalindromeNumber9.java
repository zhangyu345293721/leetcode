package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 9 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindrome-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PalindromeNumber9 {

    @Test
    public void palindromeNumberTest() {
        boolean result = isPalindrome2(121);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 判断数字是不是回文串(如果是回文数显然不会溢出)
     *
     * @param x 数字
     * @return 布尔值
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (x != 0) {
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        return reverse == temp;
    }
}
