# -*- coding:utf-8 -*-
'''
最长前缀
author:zhangyu
date:2020/2/13
'''
from typing import List


def is_all_match(sub_str: str, strs: List[str]) -> bool:
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


def longest_common_prefix(strs: List[str]) -> str:
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
        flag = is_all_match(sub_str, strs)
        if flag:
            longest_str = sub_str
        else:
            return sub_str
    return longest_str


if __name__ == '__main__':
    strs = ["c", "c"]
    longest_str = longest_common_prefix(strs)
    print(longest_str)
