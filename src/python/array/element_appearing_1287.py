# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/11
'''
from typing import List


def findSpecialInteger(arr: List[int]) -> int:
    '''
        找出数组中出现次数大于25%
    Args:
        arr: 数组
    Returns:
        数
    '''
    arr_dict = {}
    for num in arr:
        if arr_dict.keys().__contains__(num):
            arr_dict[num] += 1
        else:
            arr_dict[num] = 1
    for key in arr_dict.keys():
        if arr_dict[key] * 4 > len(arr):
            return key
    return -1


if __name__ == '__main__':
    arr = [1, 2, 2, 6, 6, 6, 6, 7, 10]
    num = findSpecialInteger(arr)
    print(num)
