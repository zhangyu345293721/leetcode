# encoding='utf-8'
'''
/**
 * This is the solution of No.221 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def get_max(self, matrix: List[List[int]], row_index: int, col_index: int) -> int:
        '''
            获取最大值
        Args:
            matrix: 二维数组
            row_index: 行下标
            col_index: 列下标
        Returns:
            最大长度数量
        '''
        row, col = len(matrix), len(matrix[0])
        if matrix[row_index][col_index] == '0':
            return 0
        length = 1
        max_size = min(row - row_index, col - col_index)
        for size in range(1, max_size):
            for i in range(row_index, row_index + size + 1):
                new_col = col_index + size
                if matrix[i][new_col] == '0':
                    return length * length
            for j in range(col_index, col_index + size + 1):
                new_row = row_index + size
                if matrix[new_row][j] == '0':
                    return length * length
            length += 1
        return length * length

    def maximal_square(self, matrix: List[List[chr]]) -> int:
        '''
            获取最大正方形
        Args:
            matrix: 输入二维数组
        Returns:
            最大正方形数量
        '''
        if matrix == None or len(matrix) < 1:
            return 0
        row = len(matrix)
        col = len(matrix[0])
        max_square = 0
        for i in range(row):
            for j in range(col):
                temp = self.get_max(matrix, i, j)
                max_square = max(max_square, temp)
        return max_square

    def maximal_square2(self, matrix: List[List[chr]]) -> int:
        '''
            获取最大正方形
        Args:
            matrix: 输入二维数组
        Returns:
            最大正方形数量
        '''
        if matrix == None or len(matrix) < 1:
            return 0
        row = len(matrix)
        col = len(matrix[0])
        dp = [[0 for x in range(col)] for y in range(row)]
        max_length = 0
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1
                    max_length = max(max_length, dp[i][j])
        return max_length * max_length


if __name__ == '__main__':
    chs = \
        [['1', '0', '1', '0', '0'],
         ['1', '0', '1', '1', '1'],
         ['1', '1', '1', '1', '1'],
         ['1', '0', '0', '1', '0']]
    solution = Solution()
    num = solution.maximal_square2(chs)
    assert num == 4
