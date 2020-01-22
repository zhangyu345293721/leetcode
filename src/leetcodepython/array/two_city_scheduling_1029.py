# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/22
'''
from typing import List


def two_city_scheduling(arr: List[List[int]]) -> int:
    '''
        找出一半的人去的城市最小总距离
    Args:
        arr: 二维数组
    Returns:
        距离
    '''
    arr.sort(key=lambda s: s[0] - s[1])
    size = len(arr)
    a_sum = sum([arr[i][0] for i in range(size // 2)])
    b_sum = sum(arr[i][1] for i in range(size // 2 , size))
    return a_sum + b_sum


if __name__ == '__main__':
    arr = [[10, 20], [30, 200], [400, 50], [30, 20]]
    total_sum = two_city_scheduling(arr)
    print(total_sum)
