# -*- coding:utf-8 -*-
'''
计算纸牌分割问题
author:zhangyu
date:2020/3/27
'''
from math import gcd
from typing import List


def has_groups_size_x(deck: List[int]) -> bool:
    '''
        可不可分成相同给数量的组
    Args:
        deck: 数组
    Returns:
        布尔值
    '''
    if not deck or len(deck) < 2:
        return False
    arr = [0] * 10000
    for num in deck:
        arr[num] += 1
    x = 0
    for num in arr:
        if num > 0:
            x = gcd(x, num)
            if x == 1:
                return False
    return x >= 2


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 4, 3, 2, 1]
    flag = has_groups_size_x(arr)
    print(flag)
