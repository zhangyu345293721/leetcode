# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 121 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def max_profit(prices: List[int]) -> int:
    '''
        计算最大利润
    Args:
        prices: 价格数组
    Returns:
        最大利润
    '''
    if not prices or len(prices)<2:
        return 0
    length = len(prices)
    max_profit = 0
    for i in range(length - 1):
        for j in range(i + 1, length):
            max_profit = max(max_profit, prices[j] - prices[i])
    return max_profit


def max_profit2(prices: List[int]) -> int:
    '''
        计算最大利润
    Args:
        prices: 价格数组
    Returns:
        最大利润
    '''
    if not prices or len(prices)<2:
        return 0
    max_profit = 0
    min_price = prices[0]
    for i in range(len(prices)):
        max_profit = max(max_profit, prices[i] - min_price)
        min_price = min(min_price, prices[i])
    return max_profit

if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    max_profit = max_profit2(prices)
    print(max_profit)
