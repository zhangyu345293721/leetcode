'''
/**
 * This is the solution of No.54 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def spiral_order(self, matrix: List[List[int]]) -> List[int]:
        '''
            顺时针打印数组
        Args:
            matrix: 二维数组
            Returns: 一维数组
        '''
        res = []
        while matrix:
            res += matrix.pop(0)
            matrix = list(zip(*matrix))[::-1]
        return res

    def spiral_order2(self, matrix: List[List[int]]) -> List[int]:
        '''
            顺时针打印数组
        Args:
            matrix: 二维数组
            Returns: 一维数组
        '''
        res = []
        top, bottom, left, right = 0, len(matrix) - 1, 0, len(matrix[0]) - 1
        while True:
            # 左上 -> 右上
            for i in range(left, right + 1):
                res.append(matrix[top][i])
            top += 1
            if top > bottom:
                break
            # 右上 -> 右下
            for i in range(top, bottom + 1):
                res.append(matrix[i][right])
            right -= 1
            if left > right:
                break
            # 右下 -> 左下
            for i in range(right, left - 1, -1):
                res.append(matrix[bottom][i])
            bottom -= 1
            if top > bottom:
                break
            # 左下 -> 左上
            for i in range(bottom, top - 1, -1):
                res.append(matrix[i][left])
            left += 1
            if left > right:
                break
        return res

    def spiral_order3(self, matrix: List[List[int]]) -> List[int]:
        '''
            逆时针打印数组
        Args:
            matrix: 二维数组
            Returns: 一维数组
        '''
        res = []
        top, bottom, left, right = 0, len(matrix) - 1, 0, len(matrix[0]) - 1
        while True:
            # 左 -> 底部
            for i in range(top, bottom + 1):
                res.append(matrix[i][left])
            left += 1
            if left > right:
                break
            # 底部 ->  右
            for i in range(left, right + 1):
                res.append(matrix[bottom][i])
            bottom -= 1
            if top > bottom:
                break
            # 右 -> 上
            for i in range(top, bottom + 1)[::-1]:
                res.append(matrix[i][right])
            right -= 1
            if left > right:
                break
            # 右上 -> 左上
            for i in range(left, right + 1)[::-1]:
                res.append(matrix[top][i])
            top += 1
            if top > bottom:
                break
        return res


if __name__ == '__main__':
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    solution = Solution()
    result = solution.spiral_order2(matrix)
    print(result)
    assert result == [1, 2, 3, 6, 9, 8, 7, 4, 5]
