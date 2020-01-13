# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/13
'''


def is_monotonic(arr):
    '''
        判断数组是否一致增减
    Args:
        arr:数组
    Returns:
        布尔值
    '''
    if len(arr) < 2:
        return len(arr) < 2
    increase_count = 0
    decrease_count = 0
    for i in range(1, len(arr)):
        if arr[i] - arr[i - 1] >= 0:
            increase_count += 1
        if arr[i] - arr[i - 1] <= 0:
            decrease_count -= 1
    return decrease_count == len(arr) - 1 or increase_count == len(arr) - 1


if __name__ == '__main__':
    arr = [1]
    flag = is_monotonic(arr)
    print(flag)
