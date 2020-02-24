# encoding='utf-8'

'''
找出是否能跳出这个数组
author:zhangyu
date:2019.8.29
'''
from typing import List


def get_judge_jump_arr(arr: List[int]) -> bool:
    '''
        看是否能跳过数组
    Args:
        arr: 输入数组
    Returns:
        布尔值
    '''
    max = 0
    length = len(arr)
    for index in range(1, length):
        if arr[index - 1] == 0 and index > arr[max] + max:
            return False
        if arr[max] - (index - max) < arr[index]:
            max = index
    return True


def get_judge_jump_arr2(arr: List[int]) -> bool:
    '''
         跳远数组
    Args:
        arr: 数组
    Returns:
        是否能调到最后，布尔值
    '''''
    max = 0
    for i in range(1, len(arr)):
        if arr[i - 1] == 0 and i > max + arr[max]:
            return False
        if arr[i] > arr[max] - (i - max):
            max = i
    return True


def get_judge_jump_arr3(arr: List[int]) -> bool:
    '''
         跳远数组
    Args:
        arr: 数组
    Returns:
        是否能调到最后，布尔值
    '''''
    if len(arr) < 2:
        return True
    if arr == None or arr[0] == 0:
        return True
    for i in range(len(arr)):
        if arr[i] == 0:
            count = 0
            j = i - 1
            while j >= 0:
                if arr[j] > (j - i):
                    break
                else:
                    count += 1
                j -= 1
            if count == i:
                return False
    return True


if __name__ == '__main__':
    arr = [2, 3, 1, 1, 4]
    flag = get_judge_jump_arr3(arr)
    print(flag)
