'''
author:zhangyu
date:2020.6.5
'''
from typing import List

def spiral_order(matrix: List[List[int]]) -> List[int]:
    '''
        顺时针打印数组
    Args:
        matrix: 二维数组
        Returns: 一维数组
    '''
    res = []
    while matrix:
        res += matrix.pop(0)
        matrix = list(zip(*matrix))[::-1]
    return res


if __name__ == '__main__':
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(matrix.pop(0))
    print(matrix)
    print(list(zip(*matrix))[::-1])
    result = spiral_order(matrix)
    print(result)
