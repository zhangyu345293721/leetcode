# encoding='utf-8'
'''
大多数元素
author:zhangyu
date:2020.2.22
'''
from typing import List


def majority_element(nums: List[int]) -> int:
    '''
        大多数元素
    Args:
        nums: 数组
    Returns:
        元素
    '''
    num_dic = {}
    for num in nums:
        if num in num_dic:
            num_dic[num] += 1
        else:
            num_dic[num] = 1
    for key in num_dic.keys():
        if num_dic[key] >= len(nums) / 2:
            return key
    return -1


def majority_element2(nums: List[int]) -> int:
    '''
        大多数元素
    Args:
        nums: 数组
    Returns:
        元素
    '''
    majority, count = 0, 0
    for num in nums:
        if count == 0:
            majority = num
            count += 1
        elif majority == num:
            count += 1
        else:
            count -= 1
    return majority


if __name__ == '__main__':
    nums = [1, 2, 2, 2, 3]
    num = majority_element(nums)
    print(num)
