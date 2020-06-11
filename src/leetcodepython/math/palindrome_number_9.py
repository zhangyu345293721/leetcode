# encoding='utf-8'

'''
判断是否是回文串
author:zhangyu
date:2020.6.10
'''


def is_palindrome(num: int) -> int:
    '''
        判断一个数是不是回文串
    Args:
        num: 数字
    Returns:
        回文串
    '''
    if num < 0:
        return False
    reverse = 0
    temp = num
    while num != 0:
        reverse = 10 * reverse + num % 10
        num = num // 10
    return reverse == temp

def is_palindrome2(num: int) -> int:
    '''
        判断一个数是不是回文串
    Args:
        num: 数字
    Returns:
        回文串
    '''
    temp=str(num)[::-1]
    return temp==str(num)
if __name__ == '__main__':
    num = 121
    flag = is_palindrome2(num)
    s=str(123)
    print(flag)