# encoding='utf-8'

'''
求表面积
author:zhangyu
date:2020.3.25
'''
from typing import List


def surface_area(grid: List[List[int]]) -> int:
    '''
        计算表面积
    Args:
        grid: 二维数组
    Returns:
        表面积
    '''
    if not grid or len(grid) < 1:
        return 0
    n, area = len(grid), 0
    for i in range(n):
        for j in range(n):
            if (grid[i][j]) > 0:
                area += (grid[i][j] * 4) + 2
                if i > 0:
                    area -= min(grid[i][j], grid[i - 1][j]) * 2
                if j > 0:
                    area -= min(grid[i][j], grid[i][j - 1]) * 2
    return area


if __name__ == '__main__':
    grid = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    area = surface_area(grid)
    print(area)
