package leetcode.list;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class dynamicProgramSample {
    @Test
    public void fun() {
        int n = 10;
        int methods = stairProblem2(10);
        System.out.println(methods);
    }

    // 动态规划： 时间复杂度:O(n) 空间复杂度：O(n)
    private int stairProblem(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        //if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 递归  时间复杂度：O(n) 空间复杂度O(n)
    private int stairProblem2(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return stairProblem(n - 1) + stairProblem(n - 2);
    }

    // 动态规划的方式2  时间复杂度:O(n) 空间复杂度O(1)
    private int stairProblem3(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
