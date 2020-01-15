# -*- coding:utf-8 -*-
'''
测试数组是否包含重复数
author:zhangyu
date:2020/1/14
'''
from typing import List


def contains_duplicate(nums: List[int]) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_dict = {}
    for num in nums:
        if number_dict.keys().__contains__(num):
            number_dict[num] += 1
        else:
            number_dict[num] = 1
    for num in number_dict.values():
        if num > 1:
            return True
    return False


def contains_duplicate2(nums: List[int]) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_set = set()
    for num in nums:
        if number_set.__contains__(num):
            return True
        else:
            number_set.add(num)
    return False


if __name__ == '__main__':
    arr = [1, 2, 3, 3, 4]
    print(contains_duplicate2(arr))
