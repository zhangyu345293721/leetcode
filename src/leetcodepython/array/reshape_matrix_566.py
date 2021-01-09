# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 566 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reshape-the-matrix
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def matrix_reshape(self, nums: List[List[int]], r: int, c: int) -> List[List[int]]:
        '''
            矩阵变换
        Args:
            nums: 数组
            r: 行
            c: 列
        Returns:
            转换后数组
        '''
        arr_list = []
        for i in range(len(nums)):
            for j in range(len(nums[0])):
                arr_list.append(nums[i][j]);
        length = len(arr_list)
        if length % r != 0 or length % c != 0 or c * r != length:
            return nums
        new_arr = [[0 * r] * c]
        index = 0
        for i in range(len(r)):
            for j in range(len(c)):
                new_arr[i][j] = arr_list[index]
                index += 1
        return new_arr


if __name__ == '__main__':
    arr = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16], [17, 18, 19, 20]]
    r = 42
    c = 5
    solution = Solution()
    new_arr = solution.matrix_reshape(arr, r, c)
    print(new_arr)
    assert new_arr==[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16], [17, 18, 19, 20]]

