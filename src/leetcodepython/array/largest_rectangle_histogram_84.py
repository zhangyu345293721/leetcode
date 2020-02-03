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
    if heights == None or len(heights) < 1:
        return 0
    stack = []
    max_area = 0
    index = 0
    while index < len(heights):
        if len(stack) < 1 or (index < len(heights) and heights[index] >= heights[stack[-1]]):
            stack.append(index)
            index += 1
        else:
            top = stack.pop()
            width = index if len(stack) < 1 else index - stack[-1] - 1
            max_area = max(max_area, width * heights[top])
    return max_area


if __name__ == '__main__':
    arr = [2, 1, 5, 6, 2, 3]
    max_area = largest_rectangle_histogram(arr)
    print(max_area)
