'''
重复0
author:zhangyu
date:2020.1.18
'''
from typing import List


def duplicate_zeros(arr: List[int]) -> None:
    '''
        重复数组中的0
    Args:
        nums: 数组
    '''
    nums = []
    for i in range(len(arr)):
        if arr[i] == 0:
            nums.append(0)
        nums.append(arr[i])
        if len(arr) == len(nums):
            arr = nums
            return


def duplicate_zeros2(arr: List[int]) -> None:
    '''
        重复数组中的0
    Args:
        nums: 数组
    '''
    i = 0
    while i < len(arr):
        if arr[i] == 0:
            arr.insert(i, 0)
            arr.pop()
            i += 2
        else:
            i += 1


if __name__ == '__main__':
    nums = [1, 0, 2, 3, 0, 4, 5, 0]
    duplicate_zeros2(nums)
