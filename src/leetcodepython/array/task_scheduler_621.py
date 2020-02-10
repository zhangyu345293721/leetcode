# -*- coding:utf-8 -*-
'''
任务分配问题
author:zhangyu
date:2020/2/10
'''
from typing import List


def least_interval(tasks: List[chr], n: int) -> int:
    '''
        任务分配问题
    Args:
        tasks:任务数组
        n:数量
    Returns:
        数字
    '''
    map = [0] * 26
    for ch in tasks:
        map[ch - ord('A')] += 1
    map.sort()
    max_height = map[25] - 1
    max_slots = max_height * n
    i = 24
    while i >= 0 and map[i] != 0:
        max_slots -= min(max_height, map[i])
        i += 1
    return max(len(tasks) + max_slots, len(tasks))
