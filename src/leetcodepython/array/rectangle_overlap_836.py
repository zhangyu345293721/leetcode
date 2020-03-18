# encoding='utf-8'

'''
author:zhangyu
date:2020.3.18
description:判断正方形是否重叠
'''
from typing import List


def is_rectangle_overlap(rec1: List[int], rec2: List[int]) -> bool:
    '''
        获取最小路径
    Args:
        grid: 二维数组
    Returns:
        最小路径
    '''
    x11, y11, x12, y12 = rec1[0], rec1[1], rec1[2], rec1[3]
    x21, y21, x22, y22 = rec2[0], rec2[1], rec2[2], rec2[3]
    y_flag = not (y21 >= x12 or y22 <= y11)
    x_flag = not (x21 >= x12 or x22 <= x11)
    return x_flag and y_flag


if __name__ == '__main__':
    rec1 = [5, 15, 8, 18]
    rec2 = [0, 3, 7, 9]
    flag = is_rectangle_overlap(rec1, rec2)
    print(flag)
