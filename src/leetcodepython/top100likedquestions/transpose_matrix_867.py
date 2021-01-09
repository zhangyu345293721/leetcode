# encoding='utf-8'

'''
/**
 * This is the solution of No. 867 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/transpose-matrix
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
import numpy as np


class Solution:

    def transpose(self, arr: List[List[int]]) -> List[List[int]]:
        '''
            转置二维数组
        Args:
            arr: 二维数组
        Returns:
            转置后的数组
        '''
        return zip(*arr)

    def transpose(self, arr: List[List[int]]) -> List[List[int]]:
        '''
            转置二维数组
        Args:
            arr: 二维数组
        Returns:
            转置后的数组
        '''
        m, n = len(arr[0]), len(arr)
        new_arr = np.zeros((m, n), dtype=int)
        for i in range(len(arr)):
            for j in range(arr[0]):
                new_arr[j][i] = arr[i][j]
        return new_arr


if __name__ == '__main__':
    nums = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    solution = Solution()
    res = solution.transpose(nums)
    print(res)
