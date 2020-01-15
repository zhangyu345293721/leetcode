# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/11
'''
from typing import List


def get_count(A: List[int]) -> int:
    '''
        计算数组的和
    Args:
        A: 输入数组
    Returns:
        求和
    '''
    count = 0
    for num in A:
        if num % 2 == 0:
            count += num
    return count


def sum_even_after_queries(A: List[int], queries: List[List[int]]) -> List[int]:
    '''
        操作数组
    Args:
        A: 数组原始数组
        queries: 按照要求操作数组
    Returns:
        操作后数组
    '''
    new_A = []
    for i in range(len(queries)):
        index = queries[i][1]
        num = queries[i][0]
        A[index] += num
        count = get_count(A)
        new_A.append(count)
    return new_A


if __name__ == '__main__':
    A = [1, 2, 3, 4]
    queries = [[1, 0], [-3, 1], [-4, 0], [2, 3]]
    new_A = sum_even_after_queries(A, queries);
    print(new_A)
