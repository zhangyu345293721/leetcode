# encoding='utf-8'

'''
/**
 * This is the solution of No. 1014 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-sightseeing-pair
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
import sys


class Solution:

    def best_sight_seeing(self, A: List[int]) -> int:
        '''
            获取最佳观光组合
        Args:
            A: 数组A
        Returns:
            最佳观光值
        '''
        length = len(A)
        result = -sys.maxsize
        for i in range(length):
            for j in range(i + 1, length):
                total = A[i] + A[j] + i - j
                result = max(total, result)
        return result

    def best_sight_seeing_2(self, A: List[int]) -> int:
        '''
            获取最佳观光组合
        Args:
            A: 数组A
        Returns:
            最佳观光值
        '''
        left = A[0]
        result = -sys.maxsize
        for j in range(1, len(A)):
            result = max(result, left + A[j] - j)
            left = max(left, A[j] + j)
        return result


if __name__ == '__main__':
    A = [8, 1, 5, 2, 6]
    solution = Solution()
    result = solution.best_sight_seeing(A)
    print(result)
    assert result == 11
