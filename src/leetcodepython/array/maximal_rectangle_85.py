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


def maximal_rectangle(matrix: List[List[chr]]) -> int:
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


if __name__ == '__main__':
    chs = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0']
    ]
    num = maximal_rectangle(chs)
    print(num)
