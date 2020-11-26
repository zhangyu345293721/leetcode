package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.201 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1: 
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BitwiseANDNumbersRange201 {

    @Test
    public void bitwiseANDNumbersRangeTest() {
        int m = 5;
        int n = 7;
        int result = rangeBitwiseAnd(m, n);
        Assert.assertEquals(result, 4);
    }

    /**
     * 范围内的数求与
     *
     * @param m 开始数
     * @param n 结束数
     * @return 结果
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (n != m) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return n << offset;
    }

    /**
     * 范围内的数求与
     *
     * @param m 开始数
     * @param n 结束数
     * @return 结果
     */
    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
