'''
/**
 * This is the solution of No.54 problem in the LeetCode,
 * the website of the problem is as follow:
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个矩阵，按照从外向里以逆时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 来源：力扣（LeetCode）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def spiral_reverse_order(self, matrix: List[List[int]]) -> List[int]:
        '''
            顺时针打印数组
        Args:
            matrix: 二维数组
            Returns: 一维数组
        '''
        res = []
        top, bottom, left, right = 0, len(matrix) - 1, 0, len(matrix[0]) - 1
        while True:
            for i in range(left, right + 1)[::-1]:
                res.append(matrix[top][i])
            top += 1
            if top > bottom:
                break
            for i in range(top, bottom + 1):
                res.append(matrix[i][left])
            left += 1
            if left > right:
                break
            for i in range(left, right + 1):
                res.append(matrix[bottom][i])
            bottom -= 1
            if top > bottom:
                break
            for i in range(top, bottom + 1)[::-1]:
                res.append(matrix[i][right])
            right -= 1
            if left > right:
                break
        return res


if __name__ == '__main__':
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    solution = Solution()
    result = solution.spiral_reverse_order(matrix)
    assert result == [3, 2, 1, 4, 7, 8, 9, 6, 5]
