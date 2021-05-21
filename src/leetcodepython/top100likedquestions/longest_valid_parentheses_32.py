'''
/**
 * This is the solution of No.32 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

'''
from typing import List


class Solution:
    def get_longest_valid_parentheses(self, s: List[str]) -> int:
        '''
            遍历所有的括号,计算有效字符串
        Args:
            s: 字符串
        Returns:
            匹配字符串长度
        '''
        max_len, left, right = 0, 0, 0
        for i in range(len(s)):
            if s[i] == '(':
                left += 1
            else:
                right += 1
            if left == right:
                max_len = max(max_len, 2 * right)
            if right > left:
                right, left = 0, 0
        right, left = 0, 0
        for j in range(len(s))[::-1]:
            if s[j] == '(':
                left += 1
            else:
                right += 1
            if left == right:
                max_len = max(max_len, 2 * left)
            if left > right:
                right, left = 0, 0
        return max_len

    def get_longest_valid_parentheses2(self, s: List[str]) -> int:
        '''
            遍历所有的括号,计算有效字符串
        Args:
            s: 字符串
        Returns:
            匹配字符串长度
        '''
        length = len(s)
        dp = [0] * (length + 1)
        stack = []
        for i, ch in enumerate(s):
            index = i + 1
            if ch == '(':
                stack.append(ch)
            else:
                if stack:
                    stack.pop()
                    pairs = 1 + dp[i]
                    prev_index = index - 2 * pairs
                    if prev_index >= 0:
                        pairs += dp[prev_index]
                        dp[index] = pairs
        return max(dp) * 2

    def get_longest_valid_parentheses3(self, s: List[str]) -> int:
        '''
            遍历所有的括号,计算有效字符串
        Args:
            s: 字符串
        Returns:
            匹配字符串长度
        '''
        if not s or len(s) < 1:
            return 0
        result = 0
        for i in range(len(s) - 1):
            j = i + 2
            while j <= len(s):
                if self.is_valid(s[i:j]):
                    result = max(result, len(s[i:j]))
                j += 2
        return result

    def is_valid(self, sub_s: str):
        '''
            判断是否是合法括号
        Args:
            sub_s: 字符串
        Returns:
            布尔值
        '''
        stack = []
        for ch in sub_s:
            if ch == '(':
                stack.append(ch)
            else:
                if len(stack) > 0 and stack[-1] == '(':
                    stack.pop(-1)
                else:
                    return False
        return len(stack) == 0


if __name__ == '__main__':
    s = '()('
    solution = Solution()
    max_len = solution.get_longest_valid_parentheses3(s)
    print(max_len)
    assert max_len == 2
