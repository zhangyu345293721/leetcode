# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/3/9
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
