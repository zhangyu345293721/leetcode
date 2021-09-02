# encoding='utf-8'

'''
/**
 * This is the solution of No.offer.67 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def str_invert_int(self, s: str) -> int:
        '''
            字符串转成数字
        Args:
            s: 字符串
        Returns:
            数字
        '''
        if s == None or len(s) < 1:
            return 0
        i, j = 0, len(s) - 1
        # 记录是正数还是负数
        n = 0
        MAX, MIN = 2 ** 31 - 1, -2 ** 31
        while i < j and s[i] == ' ':
            i += 1
        if i == len(s):
            return 0
        if s[i] == '-':
            i += 1
            n = 1
        elif s[i] == '+':
            i += 1
        elif ord(s[i]) < ord('0') and ord(s[i]) > ord('9'):
            return 0
        digit = 0
        while i <= j:
            if ord(s[i]) >= ord('0') and ord(s[i]) <= ord('9'):
                digit = 10 * digit + int(s[i])
                if digit > MAX:
                    return MAX if n == 0 else MIN
            else:
                break
            i += 1
        return digit if n == 0 else -digit

if __name__ == '__main__':
    s1 = "42"  # 42
    s2 = "  -42"  # -42
    s3 = " 4193 with words"  # 4193
    s4 = " words and 42"  # 0
    s5 = " -91283472332"  # -2147483648
    solution = Solution()
    res = solution.str_invert_int(s1)
    print(res)
    assert res == 42
