# encoding='utf-8'

'''
计算一个字符串中，它的子字符串包含多少回文串
author:zhangyu
date:2020.8.22
'''


def count_substrings(a: str) -> int:
    '''
         计算一个字符串中，它的子字符串包含多少回文串
    Args:
        a: 字符串
    Returns:
         子字符串个数
    '''
    global num
    num = 0
    for n in range(len(a)):
        count_sub(a, n, n);
        count_sub(a, n, n + 1);
    return num


def count_sub(a: str, start: int, end: int):
    '''
        计算该字符串是不是回文串
    Args:
        a: 字符串
        start: 开始位置
        end:   结束位置
    Returns:
        None
    '''
    global num
    while start >= 0 and end < len(a) and a[start] == a[end]:
        start -= 1
        end += 1
        num += 1


if __name__ == '__main__':
    a = "aabc"
    num = count_substrings(a)
    print(num)
