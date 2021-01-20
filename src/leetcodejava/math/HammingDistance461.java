package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 461 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/hamming-distance/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */


public class HammingDistance461 {
    @Test
    public void hammingDistanceTest() {
        int x = 1;
        int y = 4;
        int distance = hammingDistance3(x, y);
        System.out.println(distance);
        Assert.assertEquals(distance, 2);
    }

    /**
     * 计算汉明距离
     *
     * @param x 值1
     * @param y 值2
     * @return 距离
     */
    private int hammingDistance3(int x, int y) {
        int c = x ^ y;
        int res = 0;
        while (c > 0) {
            res = res + (c & 1);
            c = c >> 1;
        }
        return res;
    }

    /**
     * 计算汉明距离
     *
     * @param x 值1
     * @param y 值2
     * @return 距离
     */
    private int hammingDistance(int x, int y) {
        int res = 0;
        int max = -1;
        int min = -2;
        if (x >= y) {
            max = x;
            min = y;
        } else {
            max = y;
            min = x;
        }
        while (max != min) {
            max = max / 2;
            res++;
        }
        return res;
    }
}
