# encoding='utf-8'

'''
/**
 * This is the solution of No.279 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
import sys


class Solution:
    def num_squares(self, n: int) -> int:
        '''
            找出一个数是平方的和
        Args:
            num: 数字
        Returns:
            数字和
        '''
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            min_value = sys.maxsize
            j = 1
            while j * j <= i:
                min_value = min(min_value, 1 + dp[i - j * j])
                j += 1
            dp[i] = min_value
        return dp[i]


if __name__ == '__main__':
    solution = Solution()
    assert solution.num_squares(18) == 2
    assert solution.num_squares(13) == 2
