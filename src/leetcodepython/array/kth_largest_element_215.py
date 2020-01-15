# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.14
   description:找出第K个大的数
'''

from queue import PriorityQueue as PQ
from typing import List


def find_k_max_number(arr: List[int], k: int) -> int:
    '''
        找出第K个大的数
    Args:
        arr: 数组
        k: k个最大数
    Returns:
        第k大那个数
    '''
    new_arr = sorted(arr, reverse=True)
    return new_arr[k - 1]


def kth_largest_element_num(arr: List[int], k: int) -> int:
    '''
        找出第K个大的数
    Args:
        arr: 数组
        k: k个最大数
    Returns:
        第k大那个数
    '''
    pq = PQ()
    for ele in arr:
        pq.put(ele)
        if pq.qsize() > k:
            pq.get()
    return pq.get()


if __name__ == '__main__':
    numbers = [1, -3, 2, 9, 4, 7, 5]
    num = find_k_max_number(numbers, 2)
    print(num)
