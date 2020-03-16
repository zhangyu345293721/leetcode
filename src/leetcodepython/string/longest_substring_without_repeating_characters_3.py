# -*- coding:utf-8 -*-
'''
最长子字符串
author:zhangyu
date:2020/3/15
'''


def length_of_longest_substring(s: str) -> bool:
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
    result = length_of_longest_substring(s)
    print(result)
