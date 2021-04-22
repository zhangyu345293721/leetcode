package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.7 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-integer
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 注意：
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *  
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseInteger7 {
    @Test
    public void reverseIntegerTest() {
        int x = -123;
        int reverse = reverse(x);
        System.out.println(reverse);
        Assert.assertEquals(reverse, -321);
    }

    /**
     * 反转数字
     *
     * @param x 数字
     * @return 反转后的值
     */
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = 10 * result + x % 10;
            x = x / 10;
        }
        return (int) result == result ? (int) result : -1;
    }
}
