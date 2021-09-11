package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.Offer 16 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MyPow16 {
    @Test
    public void myPowTest() {
        double x = 2.0d;
        int n = 5;
        double result = myPow(x, n);
        System.out.println(result);
        Assert.assertEquals((int)result, 32);
    }

    /**
     * 计算pow
     *
     * @param x 数值
     * @param n 数量
     * @return 结果
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1d;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double res = myPow(x, n / 2);
        res = res * res;
        if ((n & 1) == 1 && n > 0) {
            res = res * x;
        }
        if ((n & 1) == 1 && n < 0) {
            res = res * (1 / x);

        }
        return res;
    }
}
