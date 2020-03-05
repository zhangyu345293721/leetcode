# encoding='utf-8'

'''
计算岛屿的个数
author:zhangyu
date:2020.1.9
'''
from typing import List


def num_islands(grid: List[List[str]]) -> None:
    '''
         计算岛屿个数
    Args:
        grid: 二维数组
    Returns:
        岛屿个数

    '''
    if len(grid) < 1 or len(grid[0]) < 1:
        return 0
    result = 0
    row, column = len(grid), len(grid[0])
    visited = [[False] * column for x in range(row)]
    for i in range(row):
        for j in range(column):
            if grid[i][j] == '1' and not visited[i][j]:
                helper(grid, visited, i, j)
                result += 1
    return result


def helper(grid: List[List[int]], visited: List[List[int]], x: int, y: int) -> None:
    '''
        帮助类函数
    Args:
        grid: 二维数组
        visited: 访问数组
        x: 位置x
        y: 位置y
    '''
    if x < 0 or x >= len(grid):
        return
    if y < 0 or y >= len(grid[0]):
        return
    if grid[x][y] != '1' or visited[x][y]:
        return
    visited[x][y] = True
    helper(grid, visited, x - 1, y)
    helper(grid, visited, x + 1, y)
    helper(grid, visited, x, y - 1)
    helper(grid, visited, x, y + 1)


if __name__ == '__main__':
    chs = [
        ['1', '1', '1', '1', '0'],
        ['1', '1', '0', '1', '0'],
        ['1', '1', '0', '0', '1'],
        ['0', '0', '0', '0', '0']
    ]
    num_island = num_islands(chs)
    print(num_island)
