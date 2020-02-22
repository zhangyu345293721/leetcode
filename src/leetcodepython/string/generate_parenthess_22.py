# -*- coding:utf-8 -*-
'''
字符串操作
author:zhangyu
date:2020/2/20
'''
from typing import List


def generate_parentheses(n: int) -> List[str]:
    '''
        按照要求生成括号字符串
    Args:
        n: 括号对长度
    Returns:
        链表
    '''
    result = []
    if n < 1:
        return result
    bracket_trace(result, '', 0, 0, n)
    return result


def bracket_trace(result, s: str, left: int, right: int, n: int):
    '''
        递归遍历括号
    Args:
        result: 结果集
        s: 字符串
        left: 左边
        right: 右边
        n: 长度
    '''
    if (len(s) == 2 * n):
        result.append(s)
    if left < n:
        bracket_trace(result, s + '(', left + 1, right, n)
    if right < left:
        bracket_trace(result, s + ')', left, right + 1, n);


if __name__ == '__main__':
    n = 3
    result = generate_parentheses(n)
    print(result)
