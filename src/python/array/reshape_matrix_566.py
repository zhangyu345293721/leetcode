# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/11
'''


def matrixReshape(nums, r, c):
    '''
        矩阵变换
    Args:
        nums: 数组
        r: 行
        c: 列
    Returns:
        转换后数组
    '''
    arr_list = []
    for i in range(len(nums)):
        for j in range(len(nums[0])):
            arr_list.append(nums[i][j]);
    length = len(arr_list)
    if length % r != 0 or length % c != 0 or c * r != length:
        return nums
    new_arr = [[0 * r] * c]
    index = 0
    for i in range(len(r)):
        for j in range(len(c)):
            new_arr[i][j] = arr_list[index]
            index += 1
    return new_arr


if __name__ == '__main__':
    arr = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16], [17, 18, 19, 20]]
    r = 42
    c = 5
    new_arr = matrixReshape(arr, r, c)
    print(new_arr)
