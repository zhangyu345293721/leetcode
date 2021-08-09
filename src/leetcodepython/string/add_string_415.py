# encoding='utf-8'

'''
/**
 * This is the solution of No. 415 problem in the LeetCode,
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
    def add_string(self, num1: str, num2: str) -> str:
        '''
            两个字符串相加
        Args:
            num1:字符串1
            num2:字符串2
        Returns:
            字符串结果
        '''
        sb = []
        i, j, carry = len(num1) - 1, (num2) - 1, 0
        while i >= 0 or j >= 0:
            a = 0 if i < 0 else int(num1[i])
            b = 0 if j < 0 else int(num2[j])
            total = a + b + carry
            sb.append(str(total % 10))
            carry = total // 10
            i -= 1
            j -= 1
        if carry > 0:
            sb.append(str(carry))
        return ''.join(sb[::-1])


if __name__ == '__main__':
    a = "9"
    b = "99"
    solution = Solution()
    result = solution.add_string(a, b)
    print(result)
    assert result == "108"
