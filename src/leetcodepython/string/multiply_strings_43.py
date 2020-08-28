# encoding='utf-8'

'''
字符串相乘
author:zhangyu
date:2020.8.13
'''
import numpy as np


def multiply1(num1: str, num2: str) -> str:
    '''
         对二进制字符串进行相乘
    Args:
        num1: 字符串数字1
        num2: 字符串数字2
    Returns:
         字符串数
    '''
    return str(int(num1) * int(num2))


def multiply2(num1: str, num2: str) -> str:
    '''
         对二进制字符串相加减
    Args:
        num1: 字符串数1
        num2: 字符串数2
    Returns:
         两个字符串相乘结果
    '''
    if not num1 or len(num1) < 1:
        return "0"
    if not num2 or len(num2) < 1:
        return "0"
    if 0 == num2 or 0 == num1:
        return "0"
    len1 = len(num1)
    len2 = len(num2)
    if len1 == 0 or len2 == 0:
        return "0"
    sb = []
    result = np.zeros(len2 + len1)
    carry = 0
    pointer = len(result) - 1
    i = len(num1)
    while i >= 0:
        n1 = ord(num1.index(i)) - ord("0")
        start = pointer
        carry = 0
        j = len(num2) - 1
        while j >= 0:
            n2 = ord(num2.index(j)) - ord("0")
            res = n1 * n2 + result[start] + carry
            carry = res // 10
            res %= 10
            result[start] = res
            start -= 1
        if carry > 0:
            result[start] = carry
        pointer -= 1
    if carry > 0:
        sb.append(carry)
    return "".join(sb)


if __name__ == '__main__':
    a = "11"
    b = "10"
    num = multiply1(a, b)
    print(num)
