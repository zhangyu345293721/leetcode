# encoding='utf-8'

'''
/**
 * This is the solution of No. 48 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def swap(self, matrix: List[List[int]], x1: int, y1: int, x2: int, y2: int):
        '''
            交换位置
        Args:
            matrix: 二维数组
            x1: 位置x1
            y1: 位置y2
            x2: 位置x2
            y2: 位置y2
        '''
        temp = matrix[x1][y1]
        matrix[x1][y1] = matrix[x2][y2]
        matrix[x2][y2] = temp

    def rotate(self, matrix: List[List[int]]) -> List[List[int]]:
        '''
            旋转数组
        Args:
            matrix:二维数组
        Returns:
            旋转后数组
        '''
        if matrix == None or len(matrix) < 1:
            return matrix
        # 先进性对称变换
        for i in range(len(matrix) - 1):
            j = i
            while j < len(matrix[0]):
                self.swap(matrix, i, j, j, i)
                j += 1
        # 再进行中间变换
        for i in range(len(matrix)):
            for j in range(len(matrix[0]) - 1):
                self.swap(matrix, i, j, i, len(matrix[0]) - j - 1)
        return matrix


if __name__ == '__main__':
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(matrix[i][j], end=' ')
        print()
    solution = Solution()
    matrix = solution.rotate(matrix)
    print(matrix)
    assert matrix == [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
