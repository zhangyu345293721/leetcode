# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1071 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Note:
 * - 1 <= str1.length <= 1000
 * - 1 <= str2.length <= 1000
 * - str1[i] and str2[i] are English uppercase letters.
 * ==========================================================================================================
 *
 * @author  zhangyu (zhangyuyu417@gmail.com)
 */
'''


def is_divide(sub: str, count: int, strs: str) -> bool:
    '''
        看字符串是否被整除
    Args:
        sub: 子字符串
        count: 数量
        strs: 目标字符串
    Returns:
        布尔值
    '''
    return ''.join([sub] * count) == strs


def gcd_of_strings(s1: str, s2: str) -> str:
    '''
        获取最大子字符串
    Args:
        s1: 输入s1
        s2: 输入s2
    Returns:
        最大子串
    '''
    if s1 == None or len(s1) < 1:
        return ''
    if s2 == None or len(s2) < 1:
        return ''
    if s1 == s2:
        return s1
    if len(s1) < len(s2):
        return gcd_of_strings(s2, s1)
    temp, end = '', len(s2)
    for i in range(1, end + 1):
        sub = s1[0:i]
        count1, count2 = len(s2) // len(sub), len(s1) // len(sub)
        flag1, flag2 = is_divide(sub, count1, s2), is_divide(sub, count2, s1)
        if flag1 and flag2:
            temp = sub
    return temp


def get_gcd(a: int, b: int) -> int:
    if a < b:
        return get_gcd(b, a)
    return get_gcd(b, a % b) if b > 0 else a


def gcd_of_strings2(s1: str, s2: str) -> str:
    '''
        获取最大子字符串
    Args:
        s1: 输入s1
        s2: 输入s2
    Returns:
        最大子串
    '''
    if s1 + s2 != s2 + s1:
        return ''
    index = get_gcd(len(s1), len(s2))
    return s2[0:index]


if __name__ == '__main__':
    str1 = "ABCABC"
    str2 = "ABC"
    result = gcd_of_strings2(str1, str2)
    print(result)
