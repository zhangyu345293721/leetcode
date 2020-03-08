# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/3/6
'''
from typing import List


def find_continuous_sequence(target: int) -> List[List[int]]:
    '''
        查找连续的序列
    Args:
        target: 目标值
    Returns:
        目标数组
    '''
    end = int(target / 2) + 1
    result = []
    for i in range(1, end):
        for j in range(i + 1, end + 1):
            total = (i + j) * (j - i + 1) / 2
            if total == target:
                result.append([x for x in range(i, j + 1)])
                break
    return result


def find_continuous_sequence2(target: int) -> List[List[int]]:
    '''
        查找连续的序列
    Args:
        target: 目标值
    Returns:
        目标数组
    '''
    result = []
    left,right = 1,2
    while left < right:
        total = (left + right) * (right - left + 1) / 2
        if total < target:
            right += 1
        elif total > target:
            left += 1
        else:
            result.append([x for x in range(left, right + 1)])
            left += 1
            right += 1
    return result


if __name__ == '__main__':
    result = find_continuous_sequence2(50252)
    print(result)
