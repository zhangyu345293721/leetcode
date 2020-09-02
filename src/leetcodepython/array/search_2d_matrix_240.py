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


def search_matrix(matrix: List[List[int]], target: int) -> bool:
    '''
        查找二维数组
    Args:
        matrix: 二维数组
        target: 目标值
    Returns:
        是否找到那个值
    '''
    row = len(matrix)
    if row == 0:
        return False
    col = len(matrix[0])
    i, j = 0, col - 1
    while i < row and j >= 0:
        if matrix[i][j] == target:
            return True
        elif matrix[i][j] > target:
            j -= 1
        else:
            i += 1
    return False
