//package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: HammingDistance
 * @Description: TOTO
 * @date 2018/11/28 20:30
 **/


public class HammingDistance {
    @Test
    public void fun() {
        int x = 1;
        int y = 4;
        int distance = hammingDistance2(x, y);
        System.out.println(distance);
    }

    private int hammingDistance2(int x, int y) {
        return Integer.bitCount(x^y);
    }

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
        while (max!=min){
            max=max/2;
            res++;
        }
            return res;
    }
}
