'''
/**
 * This is the solution of No. 69 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sqrtx
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def my_sqrt(self, x: int) -> int:
        '''
            被除数
        Args:
            x: 除数
        Returns:
            开方数
        '''
        return int(x ** 0.5)

    def my_sqrt_2(self, x: int) -> int:
        '''
            被除数
        Args:
            x: 除数
        Returns:
            开方数
        '''
        if x <= 1:
            return x
        num = 1
        while num * num <= x:
            num += 1
        return num - 1


if __name__ == '__main__':
    num = 8
    solution = Solution()
    result = solution.my_sqrt_2(num)
    assert result == 2
