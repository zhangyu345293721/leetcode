# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.709 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/to-lower-case
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:

    def get_low_first_char(self, strs: str) -> str:
        str_arr = []
        for ch in strs:
            str_arr.append(chr(ord(ch) + 32))
        return ''.join(str_arr)


if __name__ == '__main__':
    s = "ABC"
    solution = Solution()
    result = solution.get_low_first_char(s)
    print(result)
    assert result=="abc"
