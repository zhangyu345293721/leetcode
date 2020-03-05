# -*- coding:utf-8 -*-
'''
分发糖果问题
author:zhangyu
date:2020/3/5
'''
import numpy as np


def distribute_candies(candies: int, num_people: int) -> str:
    '''
        分发糖果给人
    Args:
        candies: 糖果数
        num_people: 人数
    Returns:
        糖果数组
    '''
    result = [0] * num_people
    i = 0
    while candies > 0:
        result[i % num_people] += min(candies, i + 1)
        candies -= (i + 1)
        i += 1
    return result


def distribute_candies(candies: int, num_people: int) -> str:
    '''
        分发糖果给人(将一维数组转成二维数组形式)
    Args:
        candies: 糖果数
        num_people: 人数
    Returns:
        糖果数组
    '''
    arr = []
    count = 1
    while candies > 0:
        if candies > count:
            arr.append(count)
        else:
            arr.append(candies)
            candies = 0
        candies -= count
        count += 1
    col = int(len(arr) / num_people) + 1
    add_zero = col * num_people - len(arr)
    arr.extend([0] * add_zero)
    x = np.array(arr)
    x = x.reshape((col, num_people))
    total_arr = []
    col = x.shape[1]
    for i in range(col):
        total_arr.append(sum(x[:, i]))
    return total_arr


if __name__ == '__main__':
    candies = 10
    num = 3
    result = distribute_candies(candies, num)
    print(result)
