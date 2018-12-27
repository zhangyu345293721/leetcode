//package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: HammingDistance
 * @Description: TOTO
 * @date 2018/11/28 20:30
 **/


public class HammingDistance2 {
    @Test
    public void fun() {
        int x = 1;
        int y = 4;
        int distance = hammingDistance3(x, y);
        System.out.println(distance);
    }

    private int hammingDistance3(int x, int y) {
        int c = x ^ y;
        int res = 0;
        while (c > 0) {
            res = res + (c & 1);
            c = c >> 1;
        }
        return res;
    }

    /*private int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }*/
}
