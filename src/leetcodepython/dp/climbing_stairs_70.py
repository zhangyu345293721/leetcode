# encoding='utf-8'

'''
/**
 * This is the solution of No.70 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def climbing_stairs1(self, n: int) -> int:
        '''
            爬楼梯问题，递归方式
        Args:
            n: 楼梯数
        Returns:
            总数量
        '''
        if n == 1:
            return 1
        if n == 2:
            return 2
        dp = [0] * (n + 1)
        dp[1], dp[2] = 1, 2
        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]

    def climbing_stairs2(self, n: int) -> int:
        '''
            爬楼梯问题，递归方式
        Args:
            n: 楼梯数
        Returns:
            总数量
        '''
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.climbing_stairs2(n - 1) + self.climbing_stairs2(n - 2)


if __name__ == '__main__':
    solution = Solution()
    assert solution.climbing_stairs2(2) == 2
    assert solution.climbing_stairs2(3) == 3
