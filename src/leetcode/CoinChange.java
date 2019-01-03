package leetcode;

import org.junit.Test;
/*
   找出硬币是否可以化成整
 */

public class CoinChange {
	@Test
	public void fun() {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		int method = CoinChange(coins, amount);
		System.out.println(method);
	}

	// 动态规划的方法
	private int CoinChange(int[] coins, int amount) {
		// TODO Auto-generated method stub
		// 当amout为0，直接返回
		if (amount == 0) {
			return 0;
		}
		// 当coins为null,获取它的长度为0，直接返回false
		if (coins == null || coins.length == 0) {
			return -1;
		}
		// 动态规划
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int res = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] > i) {
					continue;
				}
				if (dp[i - coins[j]] == -1) {
					continue;
				}
				dp[i] = 1 + dp[i - coins[j]];
				res = Math.min(res, dp[i]);
			}
			dp[i] = res;
		}
		return dp[amount];
	}
}
