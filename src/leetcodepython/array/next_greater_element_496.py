# -*- coding:utf-8 -*-
'''
下一个最大数值
author:zhangyu
date:2020/1/13
'''
from typing import List


def get_index(num: int, nums2: List[int]) -> int:
    '''
        获取数组下标
    Args:
        num: 数字1
        nums2: 数组
    Returns:
        下标
    '''
    for i in range(len(nums2)):
        if num == nums2[i]:
            return i
    return -1


def get_number(nums2: List[int], num: int) -> int:
    '''
        获取结果数组
    Args:
        index: 下标
        nums2: 数组2
        num:  数字
    Returns:
        结果数
    '''
    index = get_index(num, nums2)
    if (index == len(nums2) - 1):
        return -1
    for i in range(index + 1, len(nums2)):
        if nums2[i] > num:
            return nums2[i]
    return -1


def next_greater_element(nums1: List[int], nums2: List[int]) -> List[int]:
    '''
        获取比较大的数组
    Args:
        nums1: 数组1
        nums2: 数组2
    Returns:
        新数组
    '''
    arr = []
    for num in nums1:
        result = get_number(nums2, num)
        arr.append(result)
    return arr


if __name__ == '__main__':
    nums1 = [2, 4]
    nums2 = [1, 2, 3, 4]
    arr = next_greater_element(nums1, nums2)
    print(arr)
