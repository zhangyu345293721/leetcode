# -*- coding:utf-8 -*-
'''
能装多少水
author:zhangyu
date:2020/2/1
'''
from typing import List


def get_sum_index(nums: List[int], target: int) -> int:
    '''
        计算组成和下标
    Args:
        nums: 数组
        target: 目标值
    Returns:
        目标值下标
    '''
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]
    return [-1, -1]


def get_sum_index2(nums: List[int], target: int) -> int:
    '''
        计算组成和下标
    Args:
        nums: 数组
        target: 目标值
    Returns:
        目标值下标
    '''
    nums_dict = {}
    for i in range(len(nums)):
        if nums_dict.keys().__contains__(target - nums[i]):
            return [nums_dict[target - nums[i]], i]
        else:
            nums_dict[nums[i]] = i
    return [-1, -1]


if __name__ == '__main__':
    arr = [2, 5, 7, 11]
    target = 7
    result = get_sum_index2(arr, target)
    print(result)
