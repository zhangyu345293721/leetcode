# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/3/8
'''
from typing import List


def can_partition(nums: List[int]) -> bool:
    '''
        数组是否可以分为两半
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    total = sum(nums)
    if total % 2 == 1:
        return False
    total = int(total / 2)
    dp = [False] * (total + 1)
    dp[0] = True
    for num in nums:
        i = total
        while i >= num:
            dp[i] = dp[i] or dp[i - num]
            i -= 1
    return dp[total]


if __name__ == '__main__':
    nums = [1, 5, 11, 5]
    result = can_partition(nums)
    print(result)
