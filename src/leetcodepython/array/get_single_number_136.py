# encoding='utf-8'

'''
找出一个数组中出现的单独一个数
author:zhangyu
date:2019.8.3
'''
from typing import List


def single_number(arr: List[int]) -> int:
    '''
        求只出现一次的数字
    Args:
        arr: 数组
    Returns:
        数字
    '''
    set_arr = set()
    for ele in arr:
        if ele in set_arr:
            set_arr.remove(ele)
        else:
            set_arr.add(ele)
    return set_arr.pop()


def single_number2(arr: List[int]) -> int:
    '''
       求只出现一次的数字
   Args:
       arr: 数组
   Returns:
       数字
   '''
    single_number = arr[0]
    for i in range(1, len(arr)):
        single_number = single_number ^ arr[i]
    return single_number


if __name__ == '__main__':
    arr = [2, 3, 3, 2, 4]
    element = single_number(arr)
    print(element)
