# encoding='utf-8'

'''
author:zhangyu
date:2019.8.30
description:按照要求旋转矩阵
'''
from typing import List


def swap(matrix: List[List[int]], x1: int, y1: int, x2: int, y2: int):
    '''
        交换位置
    Args:
        matrix: 二维数组
        x1: 位置x1
        y1: 位置y2
        x2: 位置x2
        y2: 位置y2

    '''
    temp = matrix[x1][y1]
    matrix[x1][y1] = matrix[x2][y2]
    matrix[x2][y2] = temp


def rotate(matrix: List[List[int]]) -> List[List[int]]:
    '''
        旋转数组
    Args:
        matrix:二维数组
    Returns:
        旋转后数组
    '''
    if matrix == None or len(matrix) < 1:
        return matrix
    for i in range(len(matrix) - 1):
        j = i
        while j < len(matrix[0]):
            swap(matrix, i, j, j, i)
            j += 1
    return matrix


if __name__ == '__main__':
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(matrix[i][j], end=' ')
        print()
    matrix = rotate(matrix)
    print('==================================================')
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(matrix[i][j], end=' ')
        print()
