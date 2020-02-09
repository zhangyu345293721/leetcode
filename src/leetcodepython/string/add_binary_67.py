# encoding='utf-8'

'''
二进制数进行相加
author:zhangyu
date:2020.2.4

'''


def add_binary(a: str, b: str) -> str:
    '''
         对二进制字符串相加减
    Args:
        a: 二进制a
        b: 二进制b
    Returns:
         二进制数
    '''
    a_int = int(a, 2)
    b_int = int(b, 2)
    result = a_int + b_int
    return str(bin(result))


def add_binary2(a: str, b: str) -> str:
    '''
         对二进制字符串相加减
    Args:
        a: 二进制a
        b: 二进制b
    Returns:
         二进制数
    '''
    if a == None or len(a) < 1:
        return b
    if b == None or len(b) < 1:
        return a

    short_str = None
    long_str = None

    if len(a) < len(b):
        short_str = a
        long_str = b
    else:
        short_str = b
        long_str = a
    i = len(short_str) - 1
    j = len(long_str) - 1
    sb = ''
    carry = 0
    while i >= 0 or j >= 0:
        temp_a = 0
        if i >= 0:
            temp_a = int(short_str[i])
        if j >= 0:
            temp_b = int(short_str[j])
        carry += temp_a + temp_b
        sb += str(carry % 2)
        i -= 1
        j -= 1
        carry = carry // 2
    if carry > 0:
        sb += str(1)
    return sb[::-1]



if __name__ == '__main__':
    a = "11"
    b = "10"
    num = add_binary2(a, b)
    print(num)
