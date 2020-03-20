# encoding='utf-8'

'''
面试题目40
author:zhangyu
date:2020.3.20
'''
from typing import List


from queue import PriorityQueue as PQueue


def get_least_numbers(arr: List[int], k: int) -> List[int]:
    '''
        获取最小k个数
    Args:
        arr: 数组
        k: 数个数
    Returns:
        最小k个数
    '''
    arr.sort()
    return arr[:k]


def get_least_numbers2(arr: List[int], k: int) -> List[int]:
    '''
        获取最小k个数
    Args:
        arr: 数组
        k: 数个数
    Returns:
        最小k个数
    '''
    pq = PQueue()
    new_arr = []
    for num in arr:
        pq.put(num)
        if pq.qsize() > len(arr) - k:
            new_arr.append(pq.get())
    return new_arr


def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp


def partition(arr: List[int], left: int, right: int) -> int:
    pivot = arr[left]
    index = left
    for i in range(left + 1, right + 1):
        if arr[i] < pivot:
            index += 1
            swap(arr, index, i)
    swap(arr, left, index)
    return index


def get_least_numbers3(arr: List[int], k: int) -> List[int]:
    '''
        获取最小k个数
    Args:
        arr: 数组
        k: 数个数
    Returns:
        最小k个数
    '''
    length = len(arr)
    if k == 0 or k > length:
        return []
    target, left, right = k - 1, 0, length - 1
    while True:
        index = partition(arr, left, right)
        if index == target:
            return arr[:k]
        elif index < target:
            left = index + 1
        else:
            right = index - 1


if __name__ == '__main__':
    arr = [3, 4, 5, 6, 1, 3]
    k = 2
    new_arr = get_least_numbers3(arr, k)
    print(new_arr)
