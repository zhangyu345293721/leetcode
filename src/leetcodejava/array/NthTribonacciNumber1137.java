package leetcodejava.array;

import org.junit.Test;

/**
 * 斐波那契数翻版
 *
 * @author: zhangyu
 */
public class NthTribonacciNumber1137 {
    @Test
    public void testNthTribonacciNumber() {
        int num = tribonacci(37);
        System.out.println(num);
    }

    /**
     * 计算斐波那契数
     *
     * @param n 数n
     * @return 数字
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return tribonacci(n - 2) + tribonacci(n - 1) + tribonacci(n - 3);
        }
    }


    /**
     * 斐波那契数动态规划
     *
     * @param n 数字n
     * @return 最后值
     */
    public int tribonacci2(int n) {
        int[] array = new int[38];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        return array[n];
    }
}
