# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.22 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/generate-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def generate_parentheses(self, n: int) -> List[str]:
        '''
            按照要求生成括号字符串
        Args:
            n: 括号对长度
        Returns:
            链表
        '''
        result = []
        if n < 1:
            return result
        self.bracket_trace(result, '', 0, 0, n)
        return result

    def bracket_trace(self, result, s: str, left: int, right: int, n: int):
        '''
            递归遍历括号
        Args:
            result: 结果集
            s: 字符串
            left: 左边
            right: 右边
            n: 长度
        '''
        if (len(s) == 2 * n):
            result.append(s)
        if left < n:
            self.bracket_trace(result, s + '(', left + 1, right, n)
        if right < left:
            self.bracket_trace(result, s + ')', left, right + 1, n)


if __name__ == '__main__':
    n = 3
    solution = Solution()
    result = solution.generate_parentheses(n)
    print(result)
