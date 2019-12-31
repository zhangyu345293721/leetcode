package leetcode.question;

import org.junit.Test;

/**
 * 把数字换成二进制，计算二进制的中1的个数
 *
 * @author zhangyu
 **/


public class BitCount {
    @Test
    public void fun() {
        int num = 3;
        int count = bitCountStatistic(num);
        System.out.println(count);
    }

    // 计算bit的二进制中1的个数
    private int bitCountStatistic(int num) {
        int count = 0;
        while (num > 0) {
            // 统计1的个数
            count = count + (num & 1);
            // 然后数字朝右移动一位
            num = num >> 1;
        }
        // 最后返回数字中1的个数
        return count;
    }
}
