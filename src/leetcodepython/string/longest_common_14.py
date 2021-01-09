# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 14 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-common-prefix
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
import sys


class Solution:
    def is_all_match(self, sub_str: str, strs: List[str]) -> bool:
        '''
            字符串匹配问题
        Args:
            sub_str: 子字符串
            strs: 字符数组
        Returns:
            布尔值
        '''
        for i in range(1, len(strs)):
            if not strs[i].startswith(sub_str):
                return False
        return True

    def longest_common_prefix(self, strs: List[str]) -> str:
        '''
            找出最长前串
        Args:
            strs: 字符串数组
        Returns:
            最长相同前串
        '''
        if strs == None or len(strs) < 1:
            return ''
        if len(strs) < 2:
            return strs[0]
        longest_str = ''
        for i in range(1, len(strs[0]) + 1):
            sub_str = strs[0][0:i]
            flag = self.is_all_match(sub_str, strs)
            if flag:
                longest_str = sub_str
            else:
                return sub_str
        return longest_str

    def longest_common_prefix_2(self, strs: List[str]) -> str:
        '''
            暴力破解
        Args:
            strs:输入数组
        Returns:
            最长子字符串
        '''
        if not strs:
            return ""
        min_length = sys.maxsize
        for s in strs:
            if len(s) < min_length:
                min_length = len(s)
        for i in range(min_length):
            ch = strs[0][i]
            j = 1
            while j < len(strs):
                if strs[j][i] != ch:
                    return strs[0][0: i]
                j += 1
        return strs[0][0:min_length]


if __name__ == '__main__':
    strs = ["c", "c"]
    solution = Solution()
    longest_str = solution.longest_common_prefix_2(strs)
    print(longest_str)
