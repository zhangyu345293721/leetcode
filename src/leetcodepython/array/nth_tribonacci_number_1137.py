# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.1137 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/n-th-tribonacci-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def nth_tribonacci_number(self, n: int) -> int:
        '''
            计算斐波那契数
        Args:
            n: 数字
        Returns:
            数字
        '''
        arr = [0] * 38
        arr[0], arr[1], arr[2] = 0, 1, 1
        for i in range(3, n + 1):
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
        return arr[n]


if __name__ == '__main__':
    n = 25
    solution = Solution()
    num = solution.nth_tribonacci_number(n)
    print(num)
    assert num == 1389537
