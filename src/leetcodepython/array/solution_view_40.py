# encoding='utf-8'

'''
面试题目40
author:zhangyu
date:2020.3.20
'''
from typing import List

from queue import PriorityQueue as PQueue


class Solution:
    def get_least_numbers(self, arr: List[int], k: int) -> List[int]:
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

    def get_least_numbers2(self, arr: List[int], k: int) -> List[int]:
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

    def swap(self, arr: List[int], i: int, j: int) -> None:
        '''
            交换数组中两个元素的位置
        Args:
            arr: 数组
            i: 位置i
            j: 位置j
        Returns:

        '''
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp

    def partition(self, arr: List[int], left: int, right: int) -> int:
        '''
            找到分割点位置
        Args:
            arr: 数组
            left: 左边
            right: 右边
        Returns:
            下标位置
        '''
        pivot, index = arr[left], left
        for i in range(left + 1, right + 1):
            if arr[i] < pivot:
                index += 1
                self.swap(arr, index, i)
        self.swap(arr, left, index)
        return index

    def get_least_numbers3(self, arr: List[int], k: int) -> List[int]:
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
            index = self.partition(arr, left, right)
            if index == target:
                return arr[:k]
            elif index < target:
                left = index + 1
            else:
                right = index - 1


if __name__ == '__main__':
    arr = [3, 4, 5, 6, 1, 3]
    k = 2
    solution = Solution()
    new_arr = solution.get_least_numbers3(arr, k)
    print(new_arr)
