# -*- coding:utf-8 -*-
'''
长压字符串
author:zhangyu
date:2020/2/10
'''


def is_long_pressed_name(name: str, typed: str) -> bool:
    '''
        判断是不是长安字符串
    Args:
        name: 名字
        typed: 长按类型
    Returns:
        布尔值
    '''
    if name == None or len(name) < 1:
        return False
    if name[-1] != typed[-1]:
        return False
    if name[0] != typed[0]:
        return False
    i = 0
    j = 0
    while i < len(name):
        if name[i] == typed[j]:
            i += 1
            if j < len(typed):
                j += 1
        else:
            while typed[j] == typed[j - 1]:
                j += 1
            if name[i] != typed[j]:
                return False
    while j < len(typed):
        if typed[j] != name[i - 1]:
            return False
        j += 1
    return j == len(typed)


if __name__ == '__main__':
    name = "dfuyalc"
    typed = "dfuuyallc"
    b = is_long_pressed_name(name, typed)
    print(b)
