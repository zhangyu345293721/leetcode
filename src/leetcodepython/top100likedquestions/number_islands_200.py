# encoding='utf-8'

'''
/**
 * This is the solution of No.200 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


# import numpy as np


class Solution:
    def num_islands(self, grid: List[List[str]]) -> int:
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
        row, col = len(grid), len(grid[0])
        visited = [[False] * col for x in range(row)]
        # visited = np.empty((row, column), dtype=bool)
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1' and not visited[i][j]:
                    self.helper(grid, visited, i, j)
                    result += 1
        return result

    def helper(self, grid: List[List[int]], visited: List[List[int]], x: int, y: int) -> None:
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
        self.helper(grid, visited, x - 1, y)
        self.helper(grid, visited, x + 1, y)
        self.helper(grid, visited, x, y - 1)
        self.helper(grid, visited, x, y + 1)


if __name__ == '__main__':
    chs = [
        ['1', '1', '1', '1', '0'],
        ['1', '1', '0', '1', '0'],
        ['1', '1', '0', '0', '1'],
        ['0', '0', '0', '0', '0']
    ]
    solution = Solution()
    result = solution.num_islands(chs)
    print(result)
    assert result == 2
