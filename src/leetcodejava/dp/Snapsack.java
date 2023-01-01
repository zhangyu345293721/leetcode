/**
 * 背包问题：对于一组不同重量，不可分割的物品，选择其中一些物品装入背包，能不能正好装满背包？
 * 状态：boolean dp[n][w+1] 记录每阶段可达状态
 * dp[i][j] = true 表示第i个物品决策之后，背包重量为j这个状态可达
 * 例子：物品重量：{2,2,4,6,3}
 * 背包最大承重：9
 * <p>
 * 状态转移方程：（i，j）这个状态只有可能从（i-1,j) 和（i-1，j - weight[i]）两个状态转移过来
 * dp[i][j]=dp[i-1][j] || dp[i-1][j - weight[i]]
 */
public class Knapsack {

    /**
     * 空间没有优化后做法
     *
     * @param weight 商品的重量
     * @param n      商品个数
     * @param w      背部容量
     * @return 布尔值
     */
    public boolean KnapsackMem(int[] weight, int n, int w) {
        boolean[][] dp = new boolean[n][w + 1];
        dp[0][0] = true;
        if (weight[0] <= w) {
            dp[0][weight[0]] = true;
        }
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (dp[i - 1][j] == true || (j - weight[i] >= 0 && dp[i - 1][j - weight[i]] == true)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n - 1][w];
    }


    /**
     * 空间优化后做法
     *
     * @param weight 商品的重量
     * @param n      商品个数
     * @param w      背包容量
     * @return 布尔值
     */
    public boolean KnapsackMem2(int[] weight, int n, int w) {
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        if (weight[0] <= w) {
            dp[weight[0]] = true;
        }
        // 状态转移方程   第j个状态是从 装该商品和不装该商品转移过来
        for (int i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                if (dp[j] == true || (j - weight[i] >= 0 && dp[j - weight[i]] == true)) {
                    dp[j] = true;
                }
            }
        }
        return dp[w];
    }
