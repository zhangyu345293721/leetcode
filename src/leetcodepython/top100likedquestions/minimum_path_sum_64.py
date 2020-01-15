# encoding='utf-8'

'''
找出数组中重复的数字
author:zhangyu
date:2020.1.9
'''
from typing import List


def minimum_path_sum(arr: List[int]) -> int:
    '''
        获取最小路径
    Args:
        arr: 二维数组
    Returns:
        最小路径
    '''
    m, n = len(arr), len(arr[0])
    for i in range(m):
        for j in range(n):
            if i == 0 and j == 0:
                continue
            if i == 0:
                arr[0][j] += arr[0][j - 1]
            elif j == 0:
                arr[i][0] += arr[i - 1][0]
            else:
                arr[i][j] += min(arr[i - 1][j], arr[i][j - 1])
    return arr[m - 1][n - 1]


if __name__ == '__main__':
    arr = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    num = minimum_path_sum(arr)
    print(num)
