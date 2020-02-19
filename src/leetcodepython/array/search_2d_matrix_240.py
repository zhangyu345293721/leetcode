# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/20
'''
from typing import List


def search_matrix(matrix: List[List[int]], target: int) -> bool:
    '''
        查找二维数组
    Args:
        matrix: 二维数组
        target: 目标值
    Returns:
        是否找到那个值
    '''
    row = len(matrix)
    if row == 0:
        return False
    col = len(matrix[0])
    i, j = 0, col - 1
    while i < row and j >= 0:
        if matrix[i][j] == target:
            return True
        elif matrix[i][j] > target:
            j -= 1
        else:
            i += 1
    return False
