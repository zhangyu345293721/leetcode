# encoding='utf-8'
'''
/**
 * This is the solution of No. 695 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/max-area-of-island
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def helper(self, grid: List[List[int]], i: int, j: int) -> int:
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
        count += self.helper(grid, i - 1, j)
        count += self.helper(grid, i + 1, j)
        count += self.helper(grid, i, j - 1)
        count += self.helper(grid, i, j + 1)
        return count

    def max_area_island(self, grid: List[List[int]]) -> int:
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
                    count = self.helper(grid, i, j)
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
    solution = Solution()
    result = solution.max_area_island(nums)
    print(result)
    assert result == 4
