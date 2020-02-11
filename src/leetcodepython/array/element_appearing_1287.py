# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/11
'''
from typing import List


def find_special_integer(arr: List[int]) -> int:
    '''
        找出数组中出现次数大于25%
    Args:
        arr: 数组
    Returns:
        数
    '''
    arr_dict = {}
    for num in arr:
        if num in arr_dict:
            arr_dict[num] += 1
        else:
            arr_dict[num] = 1
    for key in arr_dict:
        if arr_dict[key] * 4 > len(arr):
            return key
    return -1


if __name__ == '__main__':
    arr = [1, 2, 2, 6, 6, 6, 6, 7, 10]
    num = find_special_integer(arr)
    print(num)
