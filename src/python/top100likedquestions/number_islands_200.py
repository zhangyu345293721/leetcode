# encoding='utf-8'

'''
   author:zhangyu
   date:2020.1.9
   description:计算岛屿的个数
'''


def num_islands(grid):
    '''
         计算岛屿个数
    Args:
        grid: 二维数组
    Returns:
        岛屿个数

    '''
    if len(grid == 0) or len(grid[0]) == 0:
        return 0
    result = 0
    row, column = len(grid), len(grid[0])
    visited = [[False] * row] * column
    for i in range(row):
        for j in range(column):
            if grid[i][j] == '1' and not visited[i][j]:
                helper(grid, visited, i, j)
                result += 1


def helper(grid, visited, x, y):
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
    if y < 0 or y > len(grid[0]):
        return
    if grid[x][y] != '1' or visited[x][y]:
        return
    visited[x][y] = True
    helper(grid, visited, x - 1, y)
    helper(grid, visited, x + 1, y)
    helper(grid, visited, x, y - 1)
    helper(grid, visited, x, y + 1)
