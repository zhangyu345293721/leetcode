# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/30
'''


def excel_sheet_column_number(s: str) -> int:
    '''
        字符串变成数字
    Args:
        s:字符串
    Returns:
        数字
    '''
    sum = 0
    for ch in s:
        num = ord(ch) - ord('A') + 1
        sum = sum * 26 + num
    return sum


if __name__ == '__main__':
    string = 'AB'
    arr_str = excel_sheet_column_number(string)
    print(arr_str)
