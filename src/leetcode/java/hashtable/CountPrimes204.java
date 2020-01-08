package leetcode.java.hashtable;

import org.junit.Test;

/**
 * 计算质数的个数
 *
 * @author: zhangyu
 */
public class CountPrimes204 {
    @Test
    public void testCountPrimes() {
        int n = 999983;
        int num = countPrimes(n);
        System.out.println(num);
    }

    /**
     * 计算质数的个数
     *
     * @param n 数字
     * @return 数量
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = judgePrime(i);
            if (flag) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断一个数是否是质数
     *
     * @param n 数字
     * @return 布尔值
     */
    private boolean judgePrime(int n) {
        int end = (int) Math.sqrt(n);
        boolean flag = true;
        for (int i = 2; i <= end; i++) {
            if (n % i == 0) {
                flag = false;
            }
        }
        return flag;
    }
}
