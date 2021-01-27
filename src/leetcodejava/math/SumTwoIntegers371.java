package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.371 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sum-of-two-integers
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SumTwoIntegers371 {

    @Test
    public void sumTwoIntegersTest() {
        int a = 2;
        int b = 3;
        int sum = getSum2(a, b);
        System.out.println(sum);
        Assert.assertEquals(sum, 5);
    }

    /**
     * 两个数相加
     *
     * @param a 数字a
     * @param b 数字b
     * @return 总和
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            if (b > 0) {
                b--;
                a++;
            } else {
                b++;
                a--;
            }
        }
        return a;
    }

    /**
     * 两个数相加
     *
     * @param a 数字a
     * @param b 数字b
     * @return 总和
     */
    public int getSum2(int a, int b) {
        while (b != 0) {
            int temp = a;
            a ^= b;
            b &= temp;
            b <<= 1;
        }
        return a;
    }
}
