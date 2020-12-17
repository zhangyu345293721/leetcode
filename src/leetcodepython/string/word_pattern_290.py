# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.290 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/word-pattern
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''

class Solution:
    def word_pattern(self, pattern: str, s: str) -> bool:
        '''
            判断单词与字符是否匹配
        Args:
            pattern: 模式串
            s: 匹配串
        Returns:
            布尔值
        '''
        length = len(pattern)
        words = s.split(" ")
        if len(words) != length:
            return False
        ch_map = {}
        for i, ch in enumerate(pattern):
            word = words[i]
            if ch in ch_map:
                if ch_map[ch] != word:
                    return False
            else:
                ch_map[ch] = word
        return len(ch_map.keys()) == len(set(ch_map.values()))


if __name__ == '__main__':
    pattern = "abba"
    s = "dog cat cat dog"
    solution = Solution()
    result = solution.word_pattern(pattern, s)
    assert result == True
