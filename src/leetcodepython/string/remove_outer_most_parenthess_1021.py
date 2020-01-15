# -*- coding:utf-8 -*-
'''
移除最外层括号
author:zhangyu
date:2020/1/12
'''


def remove_outer_most_parenthess(s: int) -> str:
    '''
        去除外面括号
    Args:
        s: 字符串
    Returns:
        里面括号
    '''
    stack = []
    str_arr = []
    for ch in s:
        if ch == '(':
            if stack != []:
                str_arr.append(ch)
            stack.append(ch)
        if ch == ')':
            stack.pop()
            if stack != []:
                str_arr.append(ch)
    return ''.join(str_arr)


if __name__ == '__main__':
    s = "(()())(())"
    str_num = remove_outer_most_parenthess(s)
    print(str_num)
