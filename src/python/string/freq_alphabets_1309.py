# -*- coding:utf-8 -*-
'''
解析字符串
author:zhangyu
date:2020/1/12
'''


def get_char(sub_str: str):
    '''
        对字符串进行转换
    Args:
        sub_str: 输入字符串
    Returns:
        转换后字符
    '''
    if sub_str.__contains__('#'):
        sub = sub_str[:-1]
        num = int(sub)
        return chr(num  + 96)
    return chr(int(sub_str) + 96)


def freqAlphabets(s):
    '''
        字符串转化
    Args:
        s: 输入字符串
    Returns:
        返回解析后字符串
    '''
    i = 0
    result_str = []
    while i < len(s):
        if i + 2 < len(s) and s[i + 2] == '#':
            sub_str = s[i: i + 3]
            ch = get_char(sub_str)
            result_str.append(ch)
            i += 3
        else:
            ch = get_char(s[i])
            result_str.append(ch)
            i += 1
    return ''.join(result_str)


if __name__ == '__main__':
    s = "25#"
    result = freqAlphabets(s)
    print(result)
