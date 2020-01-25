'''
最好的时间买卖股票
author:zhangyu
date:2020.1.25
'''
from typing import List


def best_time_buy_sell_stock(prices: List[int]) -> int:
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
    max_profit = best_time_buy_sell_stock(nums)
    print(max_profit)
