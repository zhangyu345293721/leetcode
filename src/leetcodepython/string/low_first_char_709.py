# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/2/9
'''


def get_low_first_char(strs: str) -> str:
    str_arr = []
    for ch in strs:
        str_arr.append(chr(ord(ch) + 32))
    return ''.join(str_arr)


if __name__ == '__main__':
    s = "ABC"
    result = get_low_first_char(s)
    print(result)
