package leetcodejava.hashtable;

import org.junit.Test;

/**
 * This is the solution of No.204 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/count-primes/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CountPrimes204 {
    @Test
    public void countPrimesTest() {
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
