# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/2/15
'''


def is_devide(sub, count, strs):
    '''
        看字符串是否被整除
    Args:
        sub: 子字符串
        count: 数量
        strs: 目标字符串
    Returns:
        布尔值
    '''
    new_str = ''.join([sub] * count)
    return new_str == strs


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
        short_str = s1
        long_str = s2
    else:
        short_str = s2
        long_str = s1
    temp = ''
    end = len(short_str)
    for i in range(1, end + 1):
        sub = short_str[0:i]
        count1 = len(short_str) // len(sub)
        count2 = len(long_str) // len(sub)
        flag1 = is_devide(sub, count1, short_str)
        flag2 = is_devide(sub, count2, long_str)
        if flag1 and flag2:
            temp = sub
    return temp


if __name__ == '__main__':
    str1 = "ABCABC"
    str2 = "ABC"
    result = gcd_of_strings(str1, str2)
    print(result)
