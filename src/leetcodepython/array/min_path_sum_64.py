# encoding='utf-8'

'''
author:zhangyu
date:2020.1.9
description:找出数组中重复的数字
'''
from typing import List


def minimum_path_sum(grid: List[List[int]]) -> int:
    '''
        获取最小路径
    Args:
        grid: 二维数组
    Returns:
        最小路径
    '''
    m, n = len(grid), len(grid[0])
    for i in range(m):
        for j in range(n):
            if i == 0 and j == 0:
                continue
            if i == 0:
                grid[0][j] += grid[0][j - 1]
            elif j == 0:
                grid[i][0] += grid[i - 1][0]
            else:
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
    return grid[m - 1][n - 1]


if __name__ == '__main__':
    grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    num = minimum_path_sum(grid)
    print(num)
