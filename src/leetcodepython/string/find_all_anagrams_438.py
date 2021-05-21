# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.438 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def find_all_anagrams(self, s: str, p: str) -> List[int]:
        '''
            查找所有的下标
        Args:
            s: 主字符串
            p: 匹配字符串
        Returns:
            所有字符串下标
        '''
        result = []
        len_n = len(s)
        len_p = len(p)
        ch_p = [0] * 26
        ch_s = [0] * 26
        for ch in p:
            ch_p[ord(ch) - ord('a')] += 1
        for i in range(len_n):
            if i >= len_p:
                ch_s[ord(s[i - len_p]) - ord('a')] -= 1
            ch_s[ord(s[i]) - ord('a')] += 1
            if ch_s == ch_p:
                result.append(i - len_p + 1)
        return result


if __name__ == '__main__':
    s = 'baa'
    p = 'aa'
    solution = Solution()
    result = solution.find_all_anagrams(s, p)
    print(result)
    assert result == [1]
