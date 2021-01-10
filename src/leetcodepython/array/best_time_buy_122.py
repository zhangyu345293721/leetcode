'''
/**
 * This is the solution of No. 122 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def best_time_buy_sell_stock(self, prices: List[int]) -> int:
        '''
            求股票最大利润
        Args:
            prices: 股票
        Returns:
            最大利润
        '''
        ans = 0
        cur_min = prices[0]
        for i in range(1, len(prices)):
            ans += max(prices[i] - cur_min, 0)
            cur_min = prices[i]
        return ans


if __name__ == '__main__':
    nums = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    max_profit = solution.best_time_buy_sell_stock(nums)
    print(max_profit)
    assert max_profit == 7
