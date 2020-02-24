# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/2/24
'''
from typing import List


def word_break(s: str, word_dict: List[str]) -> bool:
    '''
        判断一个单词是不是分成这个数组
    Args:
        s: 字符串
        word_dict: 字符表
    Returns:
        布尔值
    '''
    length = len(word_dict)
    f = [False for i in range(length + 1)]
    f[0] = True
    for i in range(1, length + 1):
        for j in range(i):
            if f[j] and (s[j:i] in word_dict):
                f[i] = True
                break;
    return f[length]


if __name__ == '__main__':
    s = "leetcode"
    word_dict = ["leet", "code"]
    flag = word_break(s, word_dict)
    print(flag)
