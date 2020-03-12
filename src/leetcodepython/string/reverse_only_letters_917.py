# encoding='utf-8'

'''
只倒转字符
author:zhangyu
date:2020.3.12
'''
from typing import List


def reverse_only_letters(chs: str) -> str:
    '''
        反转字符串
    Args:
        chs: 字符串数组
    Returns:
        反转后字符串
    '''
    if len(chs) < 2:
        return chs
    arrs = list(chs)
    i = 0
    j = len(chs) - 1
    while i < j:
        if str(arrs[i]).isalpha() and str(arrs[j]).isalpha():
            swap(arrs, i, j)
            i += 1
            j -= 1
        elif str(arrs[i]).isalpha():
            j -= 1
        elif str(arrs[j]).isalpha():
            i += 1
        else:
            i += 1
            j -= 1
    return ''.join(arrs)

def swap(chs: List[str], i: int, j: int)->None:
    '''
        交换数组位置
    Args:
        chs: 数组
        i: 位置i
        j: 位置j
    Returns:
        交换位置后的数组
    '''
    temp = chs[i]
    chs[i] = chs[j]
    chs[j] = temp


if __name__ == '__main__':
    reverse_str = reverse_only_letters('a-b-vf')
    print(reverse_str)
