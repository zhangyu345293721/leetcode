# encoding='utf-8'

'''
寻找遗失的数字
author:zhangyu
date:2019.8.20
'''
from typing import List


def get_messing_number(arr: List[int]) -> int:
    '''
        寻找缺失的数字
    Args:
        arr: 数组
    Returns:
        缺失的数
    '''
    length = len(arr)
    s = set()
    for i in range(length + 1):
        s.add(i)
    for j in range(len(arr)):
        if arr[j] in s:
            s.remove(arr[j])
    if len(s) == 1:
        return s.pop()
    else:
        return -1


def get_messing_number2(arr: List[int]) -> int:
    '''
       寻找缺失的数字
   Args:
       arr: 数组
   Returns:
       缺失的数
   '''
    sum, n = 0, len(arr)
    total_sum = (n + 1) * n // 2
    for i in range(len(arr)):
        sum += arr[i]
    return total_sum - sum


if __name__ == '__main__':
    arr = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    messing_number = get_messing_number(arr)
    print(messing_number)
