# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.3 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def length_of_longest_substring(self, s: str) -> bool:
        '''
            最大无重复字符串
        Args:
            s: 字符串
        Returns:
            长度
        '''
        dict_map = {}
        left, max_length = 0, 0
        for i in range(len(s)):
            if s[i] in dict_map:
                left = max(left, dict_map.get(s[i]) + 1)
            dict_map[s[i]] = i
            max_length = max(max_length, i - left + 1)
        return max_length


if __name__ == '__main__':
    s = "acafde"
    solution = Solution()
    result = solution.length_of_longest_substring(s)
    print(result)
