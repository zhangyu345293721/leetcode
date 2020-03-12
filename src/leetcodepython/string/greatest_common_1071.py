# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/2/15
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
