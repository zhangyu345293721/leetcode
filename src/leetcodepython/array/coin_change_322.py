# encoding='utf-8'

'''
/**
 * This is the solution of No. 322 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/coin-change/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def helper(self, coins: List[int], count: int, index: int, amount: int, min_count: int):
        '''
            dfs帮助类
        Args:
            coins: 硬币数组
            count: 数量
            index: 下标
            amount: 金额
            min_count: 最小数
        '''
        if index >= len(coins):
            return
        n = amount // coins[index]
        i = n
        while i >= 0:
            new_count = count + i
            # 剪枝操作1
            if amount == i * coins[index]:
                min_count[0] = min(min_count[0], new_count)
                break
            # 剪枝操作2
            if new_count >= min_count[0]:
                break
            self.helper(coins, new_count, index + 1, amount - i * coins[index], min_count)
            i -= 1

    def coin_change(self, coins: List[int], amount: int) -> int:
        '''
            兑换硬币最小数
        Args:
            coins: 硬币数组
            amount: 金额大小
        Returns:
            最小数量
        '''
        min_count = [amount + 1]
        coins.sort(reverse=True)
        self.helper(coins, 0, 0, amount, min_count)
        return -1 if min_count[0] == amount + 1 else min_count[0]

    def coin_change2(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        # dp[i][j] 表示从[0,i]个硬币中需要选取硬币总和为j的个数
        # 默认值 改为10001，则如果不能凑成硬币的时候，一定不会从该状态获取
        dp = [[10001] * (amount + 1) for _ in range(n + 1)]

        # 初始化：当amount = 0 时，硬币个数为0
        for i in range(n + 1):
            dp[i][0] = 0

        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                coin = coins[i - 1]
                # 如果硬币面值大于amount，或者是当前amount不能由上一个j - coin得到，则从上一个状态转移
                if coin > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i][j - coin] + 1, dp[i - 1][j])

        return dp[n][amount] if dp[n][amount] != 10001 else -1


if __name__ == '__main__':
    amount = 11
    coins = [1, 2, 5]
    solution = Solution()
    result = solution.coin_change2(coins, amount)
    print(result)
    assert result == 3
