# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 5 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def get_longest_substr1(self, s: str) -> str:
        '''
            获取字符串中最大的子回文串
        Args:
            s: 字符串
        Returns:
            最长子字符串
        '''
        if len(s) <= 1:
            return s
        s1 = ''
        s2 = ''
        for i in range(len(s) - 1):
            s1_max = self.max_str(s, i, i)
            s2_max = self.max_str(s, i, i + 1)
            s1 = s1 if len(s1) >= len(s1_max) else s1_max
            s2 = s2 if len(s2) >= len(s2_max) else s2_max
        return s1 if len(s1) > len(s2) else s2

    def max_str(self, s: str, i: int, j: int) -> str:
        '''
            最大回文串
        Args:
            s: 总字符串
            i: 下标i
            j: 下标j
        Returns:
            最大子字符串
        '''
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1
            j += 1
        return s[i + 1: j]


if __name__ == '__main__':
    s = "abac#"
    solution = Solution()
    result = solution.get_longest_substr1(s)
    print(result)
    assert 'aba' == result
