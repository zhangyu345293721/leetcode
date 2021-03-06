# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.240 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def search_matrix(self, matrix: List[List[int]], target: int) -> bool:
        '''
            查找二维数组
        Args:
            matrix: 二维数组
            target: 目标值
        Returns:
            是否找到那个值
        '''
        if not matrix:
            return False
        i, j = 0, len(matrix[0]) - 1
        while i < len(matrix) and j >= 0:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                j -= 1
            else:
                i += 1
        return False

    def search_matrix2(self, matrix: List[List[int]], target: int) -> bool:
        '''
            查找二维数组
        Args:
            matrix: 二维数组
            target: 目标值
        Returns:
            是否找到那个值
        '''
        if not matrix:
            return False
        i, j = len(matrix) - 1, 0
        while i >= 0 and j < len(matrix[0]):
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                i -= 1
            else:
                j += 1
        return False


if __name__ == '__main__':
    target = 5
    matrix = [
        [1, 4, 7, 11, 15],
        [2, 5, 8, 12, 19],
        [3, 6, 9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
    ]
    solution = Solution()
    b = solution.search_matrix2(matrix, target)
    print(b)
    assert b == True
