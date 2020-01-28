# encoding='utf-8'

'''
看字符串是否按照给定顺序排序
author:zhangyu
date:2020.1.27
'''
from typing import List


def compare(word1, word2, order):
    '''
        比较字符串
    Args:
        word1: 字符1
        word2: 字符2
        order: 顺序串
    Returns:
        布尔值
    '''
    i = 0
    n1,n2 = len(word1),len(word2)
    while i < n1 and i < n2 and word1[i] == word2[i]:
        i += 1
    if i == n1 or i == n2:
        return n1 < n2
    return order.index(word1[i]) < order.index(word2[i])


def contains_nearby_duplicate(words: List[str], order: str) -> bool:
    '''
        字符串是否按照顺序
    Args:
        words: 字符串数组
        order:  顺序
    Returns:
        布尔值
    '''
    n = len(words)
    for i in range(n - 1):
        flag = compare(words[i], words[i + 1], order)
        if not flag:
            return False
    return True


if __name__ == '__main__':
    words = ["hello", "leetcode"]
    order = "hlabcdefgijkmnopqrstuvwxyz"
    flag = contains_nearby_duplicate(words, order)
    print(flag)
