# -*- coding:utf-8 -*-
'''
对字符串要求进行转换
author:zhangyu
date:2020/1/11
'''
from typing import List


def shift_grid(grid: List[List[int]], k: int) -> List[List[int]]:
    '''
        对字符串进行转换
    Args:
        grid: 二维数组
        k: 次数
    Returns:
        转换后数组
    '''
    while k > 0:
        for i in range(len(grid)):
            j = len(grid[0]) - 1
            while j > 0:
                temp = grid[i][j]
                grid[i][j] = grid[i][j - 1]
                grid[i][j - 1] = temp
                j -= 1
            if i == len(grid) - 1:
                while i > 0:
                    temp = grid[i][0]
                    grid[i][0] = grid[i - 1][0]
                    grid[i - 1][0] = temp
                    i -= 1
                break
        k -= 1
    return grid


if __name__ == '__main__':
    grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    k = 1
    grid = shift_grid(grid, k)
    print(grid)
