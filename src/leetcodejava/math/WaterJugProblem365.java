package leetcodejava.math;

import org.junit.Test;

/**
 * 装水问题
 *
 * @author: zhangyu
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
