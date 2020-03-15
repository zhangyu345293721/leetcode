# encoding='utf-8'
'''
最大岛屿面积
author:zhangyu
date:2020.2.22
'''
from typing import List


def helper(grid: List[List[int]], i: int, j: int) -> int:
    '''
        帮助类计算岛屿大小
    Args:
        grid: 二维数组
        i: 位置1
        j: 位置j
    Returns:
        1的个数
    '''
    if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == 0:
        return 0
    grid[i][j] = 0
    count = 1
    count += helper(grid, i - 1, j)
    count += helper(grid, i + 1, j)
    count += helper(grid, i, j - 1)
    count += helper(grid, i, j + 1)
    return count


def max_area_island(grid: List[List[int]]) -> int:
    '''
        最大岛屿
    Args:
        grid: 二维数组
    Returns:
        最大岛屿
    '''
    max_island = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == 1:
                count = helper(grid, i, j)
                max_island = max(count, max_island)
    return max_island


if __name__ == '__main__':
    # nums = [[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
    #         [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    #         [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
    #         [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
    #         [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
    #         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
    #         [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    #         [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]]
    nums = [[0, 1, 1], [0, 1, 1]]
    max_island = max_area_island(nums)
    print(max_island)
