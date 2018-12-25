package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: BitCount
 * @Description: TOTO
 * @date 2018/12/17 9:19
 **/


public class BitCount {
    @Test
    public void fun() {
        int num = 4;
        int count = bitCountStatistic(num);
        System.out.println(count);
    }

    private int bitCountStatistic(int num) {
        int count = 0;
        while (num > 0) {
            count = count + (num & 1);
            num = num >> 1;
        }
        return count;
    }
}
