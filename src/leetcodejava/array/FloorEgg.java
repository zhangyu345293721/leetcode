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
     * 鸡数量
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
