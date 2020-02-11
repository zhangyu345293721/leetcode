# encoding='utf-8'
'''
计算最大正方形
author:zhangyu
date:2020.2.11
'''
from typing import List


def get_max(matrix, row_index, col_index):
    '''
        获取最大值
    Args:
        matrix: 二维数组
        row_index: 行下标
        col_index: 列下标
    Returns:
        最大长度数量
    '''
    row = len(matrix)
    col = len(matrix[0])
    if matrix[row_index][col_index] == '0':
        return 0
    length = 1
    max_size = min(row - row_index, col - col_index)
    for size in range(1, max_size):
        for i in range(row_index, row_index + size + 1):
            new_col = col_index + size
            if matrix[i][new_col] == '0':
                return length * length
        for j in range(col_index, col_index + size + 1):
            new_row = row_index + size
            if matrix[new_row][j] == '0':
                return length * length
        length += 1
    return length * length


def maximal_square(matrix: List[List[chr]]) -> int:
    '''
        获取最大正方形
    Args:
        matrix: 输入二维数组
    Returns:
        最大正方形数量
    '''
    if matrix == None or len(matrix) < 1:
        return 0
    row = len(matrix)
    col = len(matrix[0])
    max = 0
    for i in range(row):
        for j in range(col):
            temp = get_max(matrix, i, j)
            if max < temp:
                max = temp
    return max


if __name__ == '__main__':
    chs = \
        [['1', '0', '1', '0', '0'],
         ['1', '0', '1', '1', '1'],
         ['1', '1', '1', '1', '1'],
         ['1', '0', '0', '1', '0']]
    num = maximal_square(chs)
    print(num)
