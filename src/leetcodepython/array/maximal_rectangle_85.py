# encoding='utf-8'

'''
找出最大长方形
author:zhangyu
date:2020.1.20
'''
from typing import List


def maximal_rectangle(matrix: List[List[chr]]) -> int:
    if matrix == None or len(matrix) < 1:
        return 0
    res = 0
    m = matrix.__len__()
    n = matrix[0].__len__()
    left = [0] * n
    right = [0] * n
    height = [0] * n
    for i in range(m):
        cur_left = 0
        cur_right = n
        for j in range(n):
            if matrix[i][j] == '1':
                height[j] += 1
            else:
                height[j] = 0
        for j in range(n):
            if matrix[i][j] == '1':
                left[j] == max(left[j], cur_left)
            else:
                left[j] = 0
                cur_left = j + 1
        j1 = n - 1
        while j1 >= 0:
            if matrix[i][j1] == '1':
                right[j1] = min(right[j1], cur_right)
            else:
                right[j1] = n
                cur_right = j1
            j1 -= 1
        for j in range(n):
            res = max(res, (right[j] - left[j]) * height[j])
    return res


if __name__ == '__main__':
    chs = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0']
    ];
    num = maximal_rectangle(chs)
    print(num)
