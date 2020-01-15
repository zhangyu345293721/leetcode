# encoding='utf-8'
'''
找出最大的连续子串
author:zhangyu
date:2019.8.28
'''
from typing import List


def get_longest_consecutive(arr: List[int]) -> int:
    '''
        找出最大的连续子串
    Args:
        arr: 数组
    Returns:
        最大子串长度
    '''
    if len(arr) <= 1:
        return len(arr)
    arr.sort()
    max_length = 1
    count = 1
    for i in range(len(arr) - 1):
        if arr[i] + 1 == arr[i + 1]:
            count += 1
        else:
            if arr[i] != arr[i + 1]:
                count = 1
        if max_length < count:
            max_length = count
    return max_length


if __name__ == '__main__':
    arr = [2, 1, 3, 3, 4]
    max_length = get_longest_consecutive(arr)
    print(max_length)
