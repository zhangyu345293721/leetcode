# -*- coding:utf-8 -*-
'''
能装多少水
author:zhangyu
date:2020/1/15
'''
from typing import List


def trapping_rain_water(arr: List[int]) -> int:
    '''
        计算数组能装多少水
    Args:
        arr:数组
    Returns:
        装的水
    '''
    if arr is None or len(arr) < 3:
        return 0
    result = 0
    size = len(arr)
    for i in range(size - 1):
        max_left = 0
        max_right = 0
        j = i
        while j >= 0:
            max_left = max(max_left, arr[j])
            j -= 1
        k = i
        while k < size:
            max_right = max(max_right, arr[k])
            k += 1
        result += min(max_left, max_right) - arr[i]
    return result


def trapping_rain_water2(arr: List[int]) -> int:
    '''
        计算数组能装多少水
    Args:
        arr:数组
    Returns:
        装的水
    '''
    if arr is None or len(arr) < 3:
        return 0
    left_max = 0
    right_max = 0
    left = 0
    right = len(arr) - 1
    tota_water = 0
    while left < right:
        if arr[left] < arr[right]:
            left_max = max(left_max, arr[left])
            tota_water += (left_max - arr[left])
            left += 1
        else:
            right_max = max(right_max, arr[right])
            tota_water += (right_max - arr[right])
            right -= 1
    return tota_water


if __name__ == '__main__':
    arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    result = trapping_rain_water2(arr)
    print(result)
