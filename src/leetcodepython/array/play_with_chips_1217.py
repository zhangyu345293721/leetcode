# encoding='utf-8'

'''
摆筹码
author:zhangyu
date:2020.2.12
'''
from typing import List


def min_cost_to_move_chips(chips: List[int]) -> int:
    '''
        摆筹码代价最小
    Args:
        chips: 数组
    Returns:
        摆筹码
    '''
    step = 0
    for num in chips:
        if num % 2 == 1:
            step += 1
    return min(step, len(chips) - step)


def min_cost_to_move_chips2(chips: List[int]) -> int:
    '''
        摆筹码代价最小
    Args:
        chips: 数组
    Returns:
        摆筹码
    '''
    step1, step2 = 0, 0
    for num in chips:
        if num % 2 == 1:
            step1 += 1
        else:
            step2 += 1
    return min(step1, step2)


if __name__ == '__main__':
    arr = [2, 2, 2, 3, 3]
    times = min_cost_to_move_chips2(arr)
    print(times)
