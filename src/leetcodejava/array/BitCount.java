package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 把数字换成二进制，计算二进制的中1的个数
 *
 * @author zhangyu
 **/

public class BitCount {
    @Test
    public void bitCountTest() {
        int num = 2;
        int result = bitCountStatistic(num);
        Assert.assertEquals(result, 1);
    }

    /**
     * 计算bit的二进制中1的个数
     *
     * @param num 数字
     * @return 数量
     */
    private int bitCountStatistic(int num) {
        int result = 0;
        while (num > 0) {
            result ^= (num & 1);
            num = num >> 1;
        }
        return result;
    }
}
