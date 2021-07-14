# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 389 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-the-difference
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def find_difference1(self, s: str, t: str) -> chr:
        '''
            找出两个字符串中不相同的部分
        Args:
            s: 字符串s
            t: 字符串t
        Returns:
            不同的字符
        '''
        total = 0
        for c in s:
            total += ord(c)
        for c in t:
            total -= ord(c)
        return chr(total)

    def find_difference2(self, s: str, t: str) -> chr:
        '''
            找出两个字符串中不相同的部分
        Args:
            s: 字符串s
            t: 字符串t
        Returns:
            不同的字符
        '''
        ch = 0
        for ch1 in s:
            ch ^= ord(ch1)
        for ch2 in t:
            ch ^= ord(ch2)
        return chr(ch)

    def find_difference3(self, s: str, t: str) -> chr:
        '''
            找出两个字符串中不相同的部分
        Args:
            s: 字符串s
            t: 字符串t
        Returns:
            不同的字符
        '''
        chs = [0 for x in range(26)]
        for ch in t:
            chs[ord(ch) - ord('a')] += 1
        for ch in s:
            chs[ord(ch) - ord('a')] -= 1
        for i in range(26):
            if chs[i] > 0:
                return chs(i + ord('a'))
        return 'a'


if __name__ == '__main__':
    s1 = 'abcd'
    s2 = 'abcde'
    solution = Solution()
    ch = solution.find_difference2(s1, s2)
    print(ch)
    assert ch == 'e'
