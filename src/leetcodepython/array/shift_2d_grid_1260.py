# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1260 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shift-2d-grid
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
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
