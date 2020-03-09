# encoding='utf-8'

'''
硬币的兑换，最小数量
author:zhangyu
date:2020.1.28
'''
from typing import List


def helper(coins, count, index, amount, min_count):
    '''
        dfs帮助类
    Args:
        coins: 硬币数组
        count: 数量
        index: 下标
        amount: 金额
        min_count: 最小数
    '''
    if index < 0 or count + amount // coins[index] > min_count[0]:
        return
    if amount % coins[index] == 0:
        min_count[0] = min(min_count[0], count + amount // coins[index])
        return
    i = amount // coins[index]
    while i >= 0:
        helper(coins, count + i, index - 1, amount - i * coins[index], min_count)
        i -= 1

def coin_change(coins: List[int], amount: int) -> int:
    '''
        兑换硬币最小数
    Args:
        coins: 硬币数组
        amount: 金额大小
    Returns:
        最小数量
    '''
    min_count = [amount + 1]
    coins.sort()
    helper(coins, 0, len(coins) - 1, amount, min_count)
    return -1 if min_count[0] == amount + 1 else min_count[0]

if __name__ == '__main__':
    amount = 11
    coins = [1, 3, 5]
    result = coin_change(coins, amount)
    print(result)
