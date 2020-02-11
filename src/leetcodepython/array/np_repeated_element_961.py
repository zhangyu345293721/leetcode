# -*- coding:utf-8 -*-
'''
一个数组出现n次
author:zhangyu
date:2020/1/16
'''
from typing import List


def repeated_n_times(A: List[int]) -> int:
    '''
        一个数组出现n次
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_dict = {}
    for num in A:
        if num in number_dict:
            number_dict[num] += 1
        else:
            number_dict[num] = 1
    for item in number_dict.items():
        if item[1] == len(A) / 2:
            return item[0]
    return -1


if __name__ == '__main__':
    arr = [1, 2, 3, 3]
    num = repeated_n_times(arr)
    print(num)
