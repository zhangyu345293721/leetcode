package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.518 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。 
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CoinChange518 {

    @Test
    public void coinChangeTest() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int result = change3(amount, coins);
        System.out.println(result);
        Assert.assertEquals(result, 4);
    }

    private int count = 0;
    /**
     * 查找并换种数
     *
     * @param amount 数量
     * @param coins  数组
     * @return 次数
     */
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        searchHelper(coins, amount, 0, 0);
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param coins  硬币数组
     * @param amount 数量
     * @param index  下标
     * @param sum    最值
     */
    public void searchHelper(int[] coins, int amount, int index, int sum) {
        if (sum == amount) {
            count++;
            return;
        }
        // 剪枝操作
        if (sum > amount) {
            return;
        }
        for (int i = index; i < coins.length; i++) {
            searchHelper(coins, amount, i, sum + coins[i]);
        }
    }

    /**
     * 动态规划
     *
     * @param amount 数量
     * @param coins  数组
     * @return 次数
     */
    public int change2(int amount, int[] coins) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        // 设置起始状态
        dp[0] = 1;
        for (int coin : coins) {
            // 记录每添加一种面额的零钱，总金额j的变化
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    // 在上一种零钱状态的基础上增大
                    // 例如对于总额5，当只有面额为1的零钱时，只有一种可能 5x1
                    // 当加了面额为2的零钱时，除了原来的那一种可能外
                    // 还加上了组合了两块钱的情况，而总额为5是在总额为3的基础上加上两块钱来的
                    // 所以就加上此时总额为3的所有组合情况
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    /**
     * 动态规划
     *
     * @param amount 数量
     * @param coins  数组
     * @return 次数
     */
    public int change3(int amount, int[] coins) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        int n = coins.length;
        // 定义dp数组
        int[][] dp = new int[n + 1][amount + 1];
        // 初始化数组
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int w = coins[i - 1];
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - w];
                }
            }
        }
        return dp[n][amount];
    }
}
