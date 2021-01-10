# encoding='utf-8'

'''
/**
 * This is the solution of No. 258 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-digits/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:

    def add_digits(self, num: int) -> int:
        '''
            加上两个数字
        Args:
            arr: 数字
        Returns:
            固定值
        '''
        total = 0
        while num > 0:
            left_number = num % 10
            total += left_number
            num = num // 10
        if total < 10:
            return total
        else:
            return self.add_digits(total)

    def add_digits2(self, num: int) -> int:
        '''
            加上两个数字
        Args:
            arr: 数字
        Returns:
            固定值
        '''
        if num == 0:
            return 0
        return 9 if num % 9 == 0 else num % 9


if __name__ == '__main__':
    num = 38
    solution = Solution()
    result = solution.add_digits2(num)
    print(result)
    assert result == 2
