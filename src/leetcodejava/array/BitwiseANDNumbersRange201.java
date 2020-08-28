package leetcodejava.array;

import org.junit.Test;

/**
 * @author: zhangyu
 */
public class BitwiseANDNumbersRange201 {

    @Test
    public void bitwiseANDNumbersRangeTest() {
        int m = 5;
        int n = 7;
        int result = rangeBitwiseAnd(m, n);
        System.out.println(result);
    }

    /**
     * 范围内的数求与
     *
     * @param m 开始数
     * @param n 结束数
     * @return 结果
     */
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (n != m) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return n << offset;
    }

    /**
     * 范围内的数求与
     *
     * @param m 开始数
     * @param n 结束数
     * @return 结果
     */
    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
