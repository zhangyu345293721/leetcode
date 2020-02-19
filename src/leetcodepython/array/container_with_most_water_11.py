# encoding='utf-8'

'''
一个点到另一个点的所有路径
author:zhangyu
date:2020.2.18
'''
from typing import List


def max_area(heights: List[int]) -> int:
    '''
        求最大面积
    Args:
        heights:长度数组
    Returns:
        最大面积
    '''
    if len(heights) < 2:
        return 0
    max_area = 0
    for i in range(len(heights) - 1):
        for j in range(i, len(heights)):
            high = min(heights[i], heights[j])
            wide = abs(i - j)
            area = high * wide
            if area > max_area:
                max_area = area
    return max_area


def max_area2(heights: List[int]) -> int:
    '''
        求最大面积
    Args:
        heights:长度数组
    Returns:
        最大面积
    '''
    if len(heights) < 2:
        return 0
    max_area, i, j = 0, 0, len(heights) - 1
    while i < j:
        area = min(heights[i], heights[j]) * abs(i - j)
        max_area = max(area, max_area)
        if heights[i] < heights[j]:
            i += 1
        else:
            j -= 1
    return max_area


if __name__ == '__main__':
    arr = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    result = max_area2(arr)
    print(result)
