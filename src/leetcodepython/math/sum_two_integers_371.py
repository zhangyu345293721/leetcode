# encoding='utf-8'

'''
/**
 * This is the solution of No.371 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sum-of-two-integers
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def get_sum(self, a: int, b: int) -> int:
        '''
            计算两个数的和
        Args:
            a: 数字a
            b: 数字b
        Returns:
            总和
        '''
        while b != 0:
            temp = a
            a ^= b
            b &= temp
            b <<= 1
        return a | b

    def get_sum2(self, a: int, b: int) -> int:
        '''
            计算两个数的和
        Args:
            a: 数字a
            b: 数字b
        Returns:
            总和
        '''
        while b != 0:
            if b > 0:
                b -= 1
                a += 1
            else:
                b += 1
                a -= 1
        return a


if __name__ == '__main__':
    a, b = 2, 5
    solution = Solution()
    result = solution.get_sum2(a, b)
    print(result)
    assert result == 7
