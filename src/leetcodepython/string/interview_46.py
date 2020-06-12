# -*- coding:utf-8 -*-
'''
查找有多少中组合形式
author:zhangyu
date:2020/6/12
'''


def translate_num(num: int) -> int:
    '''
        计算统计次数
    Args:
        num: 数字
    Returns:
        返回种数
    '''
    s = str(num)
    if len(s) < 2:
        return 1
    arr = [0] * (len(s))
    arr[0] = 1
    arr[1] = 2 if (0 < int(s[0]) and int(s[0]) < 2) or (int(s[0]) == 2 and int(s[1]) <= 5) else 1
    for i in range(2, len(s)):
        if int(s[i - 1]) > 2 or int(s[i - 1]) == 0 or (int(s[i - 1]) == 2 and int(s[i]) > 5):
            arr[i] = arr[i - 1]
        else:
            arr[i] = arr[i - 1] + arr[i - 2]
    return arr[len(s) - 1]


if __name__ == '__main__':
    num = 12258
    way = translate_num(num)
    print(way)
