# encoding='utf-8'

'''
最小长度
author:zhangyu
date:2020.3.28
'''
from typing import List


def minimum_length_encoding(words: List[str]) -> int:
    '''
        最长时间
    Args:
        words: 单词数组
    Returns:
        最大长度
    '''
    words_set=set(words)
    for word in words:
        for i in range(1,len(word)):
            if word[i:] in words_set:
                words_set.remove(word[i:])
    total_length=0
    for word in words_set:
        total_length+=len(word)+1
    return total_length

if __name__ == '__main__':
    words = ["time", "me", "bell"]
    length=minimum_length_encoding(words)
    print(length)