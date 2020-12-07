# encoding='utf-8'

'''
/**
 * This is the solution of No.861 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/score-after-flipping-matrix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def matrix_score(self, A: List[List[int]]):
        '''
            按照要求转换数组
        Args:
            A: 二维数组
        Returns:
            转换后结果
        '''
        result = 0
        rows = len(A)
        cols = len(A[0])
        for i in range(rows):
            if A[i][0] == 0:
                for j in range(cols):
                    A[i][j] = 1 - A[i][j]
        average = rows // 2
        for j in range(cols):
            # 记录1的个数
            count = 0
            for i in range(rows):
                if A[i][j] == 1:
                    count += 1
            if count <= average:
                result += pow(2, cols - 1 - j) * (rows - count)
            else:
                result += pow(2, cols - 1 - j) * count
        return result


if __name__ == '__main__':
    A = [[0, 0, 1, 1], [1, 0, 1, 0], [1, 1, 0, 0]]
    solution = Solution()
    result = solution.matrix_score(A)
    print(result)
    assert result == 39
