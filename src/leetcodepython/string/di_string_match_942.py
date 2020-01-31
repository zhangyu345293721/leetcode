# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/17
'''

from typing import List


def di_string_match(s: str) -> List[int]:
    '''
        对数字按照要求进行排序
    Args:
        s:字符串
    Returns:
        字符串数组
    '''
    start = 0
    end = len(s)
    arr = [0]* (end + 1)
    for i in range(len(s)):
        if s[i] == 'D':
            arr[i] = end
            end -= 1
        else:
            arr[i] = start
            start += 1
    arr[len(s)] = start
    return arr


if __name__ == '__main__':
    string = 'DDI'
    list_arr = di_string_match(string)
    print(list_arr)