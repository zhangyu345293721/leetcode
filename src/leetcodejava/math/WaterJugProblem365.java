package leetcodejava.math;

import org.junit.Test;

/**
 * This is the solution of No.494 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/water-and-jug-problem
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class WaterJugProblem365 {
    @Test
    public void testWaterJugProblem() {
        int x = 3;
        int y = 4;
        int z = 5;
        boolean b = canMeasureWater(x, y, z);
        System.out.println(b);
    }

    /**
     * 看x,y是否能合成z
     *
     * @param x x毫升
     * @param y y毫升
     * @param z z毫升
     * @return 布尔值
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (z == 0) {
            return true;
        }
        if (x == 0 || y == 0) {
            return x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    /**
     * 使用递归找出两个数的最大公约数
     *
     * @param m 数字m
     * @param n 数字n
     * @return 最大公约数
     */
    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }
}
