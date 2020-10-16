# encoding='utf-8'

'''
/**
 * This is the solution of No.85 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def maximal_rectangle(self, matrix: List[List[chr]]) -> int:
        '''
            计算最大矩形
        Args:
            matrix: 矩形
        Returns:
            数量
        '''
        if matrix == None or len(matrix) < 1:
            return 0
        res = 0
        m, n = len(matrix), len(matrix[0])
        left = [0] * n
        right = [0] * n
        height = [0] * n
        for i in range(m):
            cur_left = 0
            cur_right = n
            for j in range(n):
                if matrix[i][j] == '1':
                    height[j] += 1
                else:
                    height[j] = 0
            for j in range(n):
                if matrix[i][j] == '1':
                    left[j] == max(left[j], cur_left)
                else:
                    left[j] = 0
                    cur_left = j + 1
            j1 = n - 1
            while j1 >= 0:
                if matrix[i][j1] == '1':
                    right[j1] = min(right[j1], cur_right)
                else:
                    right[j1] = n
                    cur_right = j1
                j1 -= 1
            for j in range(n):
                res = max(res, (right[j] - left[j]) * height[j])
        return res

    def maximal_rectangle2(self, matrix: List[List[chr]]) -> int:
        '''
            计算最大矩形
        Args:
            matrix: 矩形
        Returns:
            数量
        '''
        if matrix == None or len(matrix) < 1:
            return 0
        res = 0
        m, n = len(matrix), len(matrix[0])
        heights = [0] * n
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    heights[j] += 1
                else:
                    heights[j] = 0
            res = max(res, self.largest_rectangle_histogram(heights))
        return res

    def largest_rectangle_histogram(self, heights: List[int]) -> int:
        '''
            计算最大矩形长度
        Args:
            heights: 数组长度
        Returns:
            矩形最大面积
        '''
        if not heights:
            return 0
        if len(heights) < 2:
            return heights[0]
        area_max = 0
        for i in range(len(heights)):
            height = heights[i]
            width = 1  # 当前宽度为1
            k = i - 1
            while k >= 0 and heights[k] >= height:
                width += 1
                k -= 1
            k = i + 1
            while k <= len(heights) - 1 and heights[k] >= height:
                width += 1
                k += 1
            area_max = max(area_max, height * width)
        return area_max


if __name__ == '__main__':
    chs = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0']
    ]
    solution = Solution()
    num = solution.maximal_rectangle2(chs)
    print(num)
