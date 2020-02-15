# encoding='utf-8'

'''
数字加上每一位数
author:zhangyu
date:2020.1.28
'''


def add_digits(num: int) -> int:
    '''
        加上两个数字
    Args:
        arr: 数字
    Returns:
        固定值
    '''
    total = 0
    while num > 0:
        left_number = num % 10
        total += left_number
        num = num // 10
    if total < 10:
        return total
    else:
        return add_digits(total)


def add_digits2(num: int) -> int:
    '''
        加上两个数字
    Args:
        arr: 数字
    Returns:
        固定值
    '''
    if num == 0:
        return 0
    return 9 if num % 9 == 0 else num % 9


if __name__ == '__main__':
    num = 38
    result = add_digits2(num)
    print(result)
