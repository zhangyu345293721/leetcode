# -*- coding:utf-8 -*-
'''
查看重复的数
author:zhangyu
date:2020/1/26
'''
from typing import List


def contains_duplicate(nums: List[int], k: int) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    for i in range(0, len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] == nums[j] and abs(i - j) <= k:
                return True
    return False


def contains_duplicate2(nums: List[int], k: int) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_dict = {}
    for i in range(len(nums)):
        if nums[i] in number_dict:
            if abs(i - number_dict[nums[i]]) <= k:
                return True
        number_dict[nums[i]] = i
    return False


if __name__ == '__main__':
    nums = [1, 2, 3, 1]
    k = 3
    print(contains_duplicate2(nums, k))
