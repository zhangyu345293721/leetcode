# encoding='utf-8'

'''
按照要求反转一个字符串
author:zhangyu
date:2019.8.19
'''
import re

def get_reverse_string(s: str, k: int) -> str:
    '''
        字符串反转
    Args:
        arr: 字符串
    Returns:
        反转后字符串
    '''
    list = []
    sb = ''
    number = len(s) // k
    for i in range(number):
        list.append(s[i * k:i * k + k])
    if number * k < len(s):
        list.append(s[number * k:len(s)])
    for i in range(len(list)):
        if i % 2 == 0:
            sb += list[i][::-1]
        else:
            sb += list[i]
    return sb


def get_reverse_string2(s: str, k: int) -> str:
    '''
        字符串反转
    Args:
        arr: 字符串
    Returns:
        反转后字符串
    '''
    if len(s) <= k:
        return s[::-1]
    if len(s) > k and len(s) <= 2 * k:
        temp_str = s[0: k]
        return temp_str[::-1] + s[k:len(s)]
    if len(s) > 2 * k:
        list = []
        sb = ''
        number = len(s) // k
        for i in range(number):
            list.append(s[i * k:i * k + k])
        if number * k < len(s):
            list.append(s[number * k:len(s)])
        for i in range(len(list)):
            if i % 2 == 0:
                sb += list[i][::-1]
            else:
                sb += list[i]
        return sb
    return '-1'


def cut_text(text: str, length: int) -> str:
    '''
        截取固定长度的字符串
    Args:
        text: 字符串
        length: 长度
    Returns:
        字符串
    '''
    textArr = re.findall('.{' + str(length) + '}', text)
    textArr.append(text[(len(textArr) * length):])
    return textArr


def get_reverse_str(arr):
    '''
        字符串反转
    Args:
        arr: 字符串
    Returns:
        反转后字符串
    '''
    s = ''
    for i in range(len(arr)):
        if i % 2 == 0:
            s += arr[i][::-1]
        else:
            s += arr[i]
    return s


if __name__ == '__main__':
    s = 'abc'
    reversed_s = get_reverse_string(s, 2)
    print(reversed_s)
