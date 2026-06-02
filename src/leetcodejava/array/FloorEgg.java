package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.xxx problem in the LeetCode,
 * the website of the problem is as follow:
 *
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 一、问题再明确
 * 给你 k 个鸡蛋，n 层楼
 * 鸡蛋从某一层扔下去会碎，比它低的都不碎，比它高的都碎
 * 我们要找：最坏情况下，最少扔几次，一定能找到临界层
 * 1. 定义 dp 数组
 * dp[i][j] = 用 i 个鸡蛋，测 j 层楼，最坏情况下最少需要扔几次
 * 我们要求的答案就是：dp[k][n]
 * 2. 状态转移方程（最关键）
 * 在第 x 层扔鸡蛋，只有两种结果：
 * 碎了：剩下 i-1 个鸡蛋，测下面 x-1 层 → dp[i-1][x-1]
 * 没碎：剩下 i 个鸡蛋，测上面 j-x 层 → dp[i][j-x]
 * 最坏情况要取两者更大的值：
 * max( dp[i-1][x-1], dp[i][j-x] ) + 1
 * 我们要选最优的 x，让这个最坏值最小：
 * dp[i][j] = min( max(dp[i-1][x-1], dp[i][j-x]) + 1 )
 *           （x 从 1 到 j 遍历）
 * 3. base case（初始条件）
 * 0 层楼：不用扔 → dp[i][0] = 0
 * 1 层楼：扔 1 次 → dp[i][1] = 1
 * 只有 1 个鸡蛋：只能逐层扔 → dp[1][j] = j
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class EggFloor {
    @Test
    public void eggFloorTest() {
        int k = 2;
        int n = 100;
        int num = eggDrop(k, n);
        Assert.assertEquals(num, 14);
    }

    /**
     * 扔鸡单数量
     *
     * @return 最少扔鸡蛋次数
     */
    public  int eggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        // init dp array
        for(int i = 0; i <= k; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
         // 只有 1 层楼，不管多少鸡蛋，都只需要 1 次
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        // 只有 1 个鸡蛋，只能逐层试，次数 = 楼层数
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }
        // 状态转移
        for (int i = 2; i <= k; i++) {       
            for (int j = 2; j <= n; j++) {   
                // 尝试在每一层 x 扔鸡蛋
                for (int x = 1; x <= j; x++) {
                    // 碎了 vs 没碎，取最坏情况
                    int worst = Math.max(dp[i - 1][x - 1], dp[i][j - x]) + 1;
                    // 在所有最坏里选最小的
                    dp[i][j] = Math.min(dp[i][j], worst);
                }
            }
        }
        return dp[k][n];
    }
}
