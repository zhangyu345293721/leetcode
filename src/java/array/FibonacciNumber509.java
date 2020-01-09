package java.array;

import org.junit.Test;

/**
 * 斐波那契数
 *
 * @author: zhangyu
 */
public class FibonacciNumber509 {
    @Test
    public void testFibonacciNumber() {
        int n = 3;
        int num = fib2(n);
        System.out.println(num);
    }

    /**
     * 斐波那契数(递归)
     *
     * @param N 输入数
     * @return 返回数
     */
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    /**
     * 斐波那契数(动态规划)
     *
     * @param N 输入数
     * @return 返回数
     */
    public int fib2(int N) {
        int[] arr = new int[N + 2];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N];
    }

    /**
     * 斐波那契数(交换方式)
     *
     * @param N 输入数
     * @return 返回数
     */
    public int fib3(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i = 2; i <= N; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
