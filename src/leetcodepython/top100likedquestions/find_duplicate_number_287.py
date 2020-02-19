# encoding='utf-8'

'''
找出数组中重复的数字
author:zhangyu
date:2019.8.22
'''
from typing import List


def find_duplicate_number(nums: List[int]) -> int:
    '''
        找出重复的数字
    Args:
        arr: 数组
    Returns:
        重复数字
    '''
    nums.sort()
    for i in range(len(nums)):
        if nums[i] == nums[i + 1]:
            return nums[i]
    return -1

def find_duplicate_number2(nums: List[int]) -> int:
    '''
       找出重复的数字
   Args:
       arr: 数组
   Returns:
       重复数字
   '''
    s = set()
    for num in nums:
        if num in s:
            return num
        else:
            s.add(num)
    return -1


if __name__ == '__main__':
    arr = [3, 2, 1, 2, 4]
    num = find_duplicate_number(arr)
    print(num)
