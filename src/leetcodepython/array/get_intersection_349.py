# encoding='utf-8'

'''
author:zhangyu
date:2019.8.4
description:找到两个数组中的交集
'''
from typing import List


class Solution:

    def get_intersection(self, arr1: List[int], arr2: List[int]) -> List[int]:
        '''
            两个数组求交集
        Args:
            arr1: 数组1
            arr2: 数组2
        Returns:
            数组交集
        '''
        arr1.sort()
        arr2.sort()
        i, j, arr = 0, 0, []
        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                i += 1
            elif arr1[i] > arr2[j]:
                j += 1
            else:
                arr.append(arr1[i])
                i += 1
                j += 1
        return arr

    def get_intersection2(self, arr1: List[int], arr2: List[int]) -> List[int]:
        '''
            两个数组求交集
        Args:
            arr1: 数组1
            arr2: 数组2
        Returns:
            数组交集
        '''
        arr, s1, s2 = [], set(), set()
        for ele in arr1:
            s1.add(ele)
        for ele in arr2:
            s2.add(ele)
        for ele in s1:
            if ele in s2:
                arr.append(ele)
        return arr

    def get_intersection3(self, arr1: List[int], arr2: List[int]) -> List[int]:
        '''
            两个数组求交集
        Args:
            arr1: 数组1
            arr2: 数组2

        Returns:
            数组交集
        '''
        s, arr = set(), []
        for ele in arr1:
            s.add(ele)
        for ele in arr2:
            if ele in s:
                arr.append(ele)
                s.remove(ele)
        return arr


if __name__ == '__main__':
    arr1 = [1, 2, 3, 1]
    arr2 = [2, 3, 4, 2]
    solution = Solution()
    arr = solution.get_intersection(arr1, arr2)
    print(arr)
    assert arr == [2, 3]
