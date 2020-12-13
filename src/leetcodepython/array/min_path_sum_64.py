# encoding='utf-8'

'''
/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-path-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
import sys


class Solution:
    def minimum_path_sum(self, grid: List[List[int]]) -> int:
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

    def minimum_path_sum2(self, grid: List[List[int]]) -> int:
        '''
            获取最小路径
        Args:
            grid: 二维数组
        Returns:
            最小路径
        '''
        if len(grid) == 0:
            return 0
        rows, cols = len(grid), len(grid[0])
        return self.minimum_path_sum_dfs(rows - 1, cols - 1, [[None for i in range(cols)] for j in range(rows)], grid)

    def minimum_path_sum_dfs(self, i: int, j: int, result, grid: List[List[int]]) -> int:
        '''
            深度优先遍历
        Args:
            i: 下标i
            j: 下标j
            result: 结果数组
            grid: 二维数组
        Returns:
            最小距离
        '''
        if i < 0 or j < 0:
            return sys.maxsize
        if i == 0 and j == 0:
            return result[i][j]
        if result[i][j] != None:
            return result[i][j]
        total = min(self.minimum_path_sum_dfs(i - 1, j, result, grid),
                    self.minimum_path_sum_dfs(i, j - 1, result, grid))
        result[i][j] = total + grid[i][j]
        return result[i][j]


if __name__ == '__main__':
    grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    solution = Solution()
    num = solution.minimum_path_sum2(grid)
    assert num == 7
