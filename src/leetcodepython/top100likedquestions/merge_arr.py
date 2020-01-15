# encoding='utf-8'

'''
合并数组
author:zhangyu
date:2020.1.9

'''
from typing import List


def merge(arr1: List[int], arr2: List[int]) -> List[int]:
    '''
        合并两个数组
    Args:
        arr1:数组1
        arr2:数组2
    Returns:
        合并后数组
    '''
    if arr1 is None or len(arr1) < 1:
        return arr2
    if arr2 is None or len(arr2) < 1:
        return arr1
    new_arr = []
    i = 0
    j = 0
    count = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            new_arr[count] = arr1[i]
            i += 1
            count += 1
        elif arr1[i] == arr2[j]:
            new_arr[count] = arr1[i]
            i += 1
            j += 1
            count += 1
        else:
            new_arr[count] = arr2[j]
            j += 1
            count += 1
        if i == len(arr1):
            for index in range(j, len(arr2)):
                new_arr[count] = arr2[index]
                count += 1
        if j == len(arr2):
            for index in range(i, len(arr1)):
                new_arr[count] = arr1[index]
                count += 1
    return new_arr


def merge2(arr1: List[int], arr2: List[int]) -> List[int]:
    '''
        合并两个数组
    Args:
        arr1:数组1
        arr2:数组2
    Returns:
        合并后数组
    '''
    if arr1 is None or len(arr1) < 1:
        return arr2
    if arr2 is None or len(arr2) < 1:
        return arr1
    arr_set = set()
    for num in arr1:
        arr_set.add(num)
    for num in arr2:
        arr_set.add(num)
    arr_list = list(arr_set)
    arr_list.sort()
    return arr_list
