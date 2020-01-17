# encoding='utf-8'

'''
找出某个点的山顶点
author:zhangyu
date:2020.1.17
'''
from typing import List


def get_peak_index_mountain_array(arr: List[int]) -> int:
    if arr is None or arr.__len__() < 3:
        return -1
    for i in range(1, len(arr) - 1):
        if arr[i] > arr[i - 1] and arr[i] > arr[i + 1]:
            return i
    return -1


if __name__ == '__main__':
    arr = [1, 2, 1, 0]
    index = get_peak_index_mountain_array(arr)
    print(index)
