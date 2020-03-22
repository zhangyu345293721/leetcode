# encoding='utf-8'
'''
将数组变成不重复数组
author:zhangyu
date:2020.3.22
'''
from typing import List

def min_increment_for_unique(A: List[int]) -> int:
    '''
        最小增加
    Args:
        A:数组
    Returns:
        独一数组
    '''
    A.sort()
    count = 0
    for i in range(1, len(A)):
        if A[i] <= A[i - 1]:
            temp = A[i]
            A[i] = A[i - 1] + 1
            count += abs(temp - A[i])
    return count


if __name__ == '__main__':
    A = [3, 2, 1, 2, 1, 7]
    count = min_increment_for_unique(A)
    print(count)
