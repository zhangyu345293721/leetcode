# -*- coding:utf-8 -*-
'''
获取自除数
author:zhangyu
date:2020/1/14
'''
from typing import List


def judge_dividing_number(i: int) -> bool:
    '''
        判断是不是自除数
    Args:
        i: 输入数
    Returns:
        布尔值
    '''
    flag = True
    temp = i
    while i > 0:
        num = i % 10
        i = i // 10
        if num == 0 or temp % num != 0:
            flag = False
    return flag


def self_dividing_numbers(left: int, right: int) -> List[int]:
    '''
        找出自除数
    Args:
        left: 左边
        right: 右边
    Returns:
        list链表
    '''
    dividing_num_list = []
    for i in range(left, right + 1):
        flag = judge_dividing_number(i)
        if flag:
            dividing_num_list.append(i)
    return dividing_num_list


if __name__ == '__main__':
    left = 1
    right = 20
    print(self_dividing_numbers(left, right))
