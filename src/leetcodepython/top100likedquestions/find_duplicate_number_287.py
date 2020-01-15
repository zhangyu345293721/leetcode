# encoding='utf-8'

'''
找出数组中重复的数字
author:zhangyu
date:2019.8.22
'''
from typing import List


def find_duplicate_number(arr: List[int]) -> int:
    '''
        找出重复的数字
    Args:
        arr: 数组
    Returns:
        重复数字
    '''
    arr.sort()
    for i in range(len(arr)):
        if arr[i] == arr[i + 1]:
            return arr[i]


def find_duplicate_number(arr: List[int]) -> int:
    '''
       找出重复的数字
   Args:
       arr: 数组
   Returns:
       重复数字
   '''
    s = set()
    for i in range(len(arr)):
        if s.__contains__(arr[i]):
            return arr[i]
        else:
            s.add(arr[i])
    return -1


if __name__ == '__main__':
    arr = [3, 2, 1, 2, 4]
    num = find_duplicate_number(arr)
    print(num)
