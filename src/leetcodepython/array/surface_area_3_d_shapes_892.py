# encoding='utf-8'

'''
/**
 * This is the solution of No. 892 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def surface_area(self, grid: List[List[int]]) -> int:
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
    solution = Solution()
    area = solution.surface_area(grid)
    assert area == 32
