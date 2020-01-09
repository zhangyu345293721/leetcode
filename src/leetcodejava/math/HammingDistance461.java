package leetcodejava.math;

import org.junit.Test;

/**
 * 计算汉明距离
 *
 * @author zhangyu
 **/


public class HammingDistance461 {
    @Test
    public void testHammingDistance() {
        int x = 1;
        int y = 4;
        int distance = hammingDistance3(x, y);
        System.out.println(distance);
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
