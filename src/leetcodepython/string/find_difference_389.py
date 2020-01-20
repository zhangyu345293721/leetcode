# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/20
'''

from typing import List


def find_difference2(s1: str, s2: str) -> List[int]:
    '''
        找出两个字符串中不相同的部分
    Args:
        s1: 字符串s1
        s2: 字符串s2
    Returns:
        不同的字符
    '''
    ch = 0
    for ch1 in s1:
        ch ^= ord(ch1)
    for ch2 in s2:
        ch ^= ord(ch2)
    return chr(ch)


def find_difference(s1: str, s2: str) -> List[int]:
    '''
        找出两个字符串中不相同的部分
    Args:
        s1: 字符串s1
        s2: 字符串s2
    Returns:
        不同的字符
    '''
    ch_set = set()
    for ch1 in s1:
        if ch_set.__contains__(ch1):
            ch_set.remove(ch1)
        else:
            ch_set.add(ch1)
    for ch2 in s2:
        if ch_set.__contains__(ch2):
            ch_set.remove(ch2)
    else:
        ch_set.add(ch2)
    return list(ch_set)[0]


if __name__ == '__main__':
    s1 = 'abcd'
    s2 = 'abcde'
    ch = find_difference(s1, s2)
    print(ch)
