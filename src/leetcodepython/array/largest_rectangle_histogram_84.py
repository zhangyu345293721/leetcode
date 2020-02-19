# encoding='utf-8'

'''
计算最大矩形体积
author:zhangyu
date:2020.1.17
'''
from typing import List


def largest_rectangle_histogram(heights: List[int]) -> int:
    '''
        计算最大矩形长度
    Args:
        heights: 数组长度
    Returns:
        矩形最大面积
    '''
    if not heights:
        return 0
    stack = []
    max_area, index = 0, 0
    length = len(heights)
    while index < length:
        if len(stack) < 1 or (index < length and heights[index] >= heights[stack[-1]]):
            stack.append(index)
            index += 1
        else:
            top = stack.pop()
            width = index if len(stack) < 1 else index - stack[-1] - 1
            max_area = max(max_area, width * heights[top])
    return max_area


if __name__ == '__main__':
    heights = [2, 1, 5, 6, 2, 3]
    max_area = largest_rectangle_histogram(heights)
    print(max_area)
