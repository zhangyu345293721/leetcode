# encoding='utf-8'

'''
找出最好的观察点
author:zhangyu
date:2020.6.17
'''
from typing import List
import sys


def best_sight_seeing(A: List[int]) -> int:
    '''
        获取最佳观光组合
    Args:
        A: 数组A
    Returns:
        最佳观光值
    '''
    length = len(A)
    result = -sys.maxsize
    for i in range(length):
        for j in range(i + 1, length):
            total = A[i] + A[j] + i - j
            result = max(total, result)
    return result


def best_sight_seeing_2(A: List[int]) -> int:
    '''
        获取最佳观光组合
    Args:
        A: 数组A
    Returns:
        最佳观光值
    '''
    left = A[0]
    result = -sys.maxsize
    for j in range(1, len(A)):
        result = max(result, left + A[j] - j)
        left = max(left, A[j] + j)
    return result


if __name__ == '__main__':
    A = [8, 1, 5, 2, 6]
    result = best_sight_seeing(A)
    print(result)
