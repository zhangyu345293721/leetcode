# encoding='utf-8'

'''
/**
 * This is the solution of No. 67 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:

    def add_binary(self, a: str, b: str) -> str:
        '''
             对二进制字符串相加减
        Args:
            a: 二进制a
            b: 二进制b
        Returns:
             二进制数
        '''
        a_int = int(a, 2)
        b_int = int(b, 2)
        result = a_int + b_int
        return str(bin(result))

    def add_binary2(self, a: str, b: str) -> str:
        '''
             对二进制字符串相加减
        Args:
            a: 二进制a
            b: 二进制b
        Returns:
             二进制数
        '''
        if a == None or len(a) < 1:
            return b
        if b == None or len(b) < 1:
            return a

        short_str = None
        long_str = None

        if len(a) < len(b):
            short_str = a
            long_str = b
        else:
            short_str = b
            long_str = a
        i = len(short_str) - 1
        j = len(long_str) - 1
        sb = ''
        carry = 0
        while i >= 0 or j >= 0:
            temp_a = 0
            if i >= 0:
                temp_a = int(short_str[i])
            if j >= 0:
                temp_b = int(short_str[j])
            carry += temp_a + temp_b
            sb += str(carry % 2)
            i -= 1
            j -= 1
            carry = carry // 2
        if carry > 0:
            sb += str(1)
        return sb[::-1]

    def add_binary3(self, a: str, b: str) -> str:
        '''
             对二进制字符串相加减
        Args:
            a: 二进制a
            b: 二进制b
        Returns:
             二进制数
        '''
        return bin(int(a, 2) + int(b, 2))[2:]


if __name__ == '__main__':
    a = "11"
    b = "10"
    solution = Solution()
    num = solution.add_binary(a, b)
    print(num)
    assert num == '0b101'
