# -*- coding:utf-8 -*-
'''
斐波那契数改良版
author:zhangyu
date:2020/1/24
'''


def nth_tribonacci_number(n: int) -> int:
    '''
        计算斐波那契数
    Args:
        n: 数字
    Returns:
        数字
    '''
    arr = [0] * 38
    arr[0], arr[1], arr[2] = 0, 1, 1
    for i in range(3, n + 1):
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
    return arr[n]


if __name__ == '__main__':
    n = 25
    num = nth_tribonacci_number(n)
    print(num)
