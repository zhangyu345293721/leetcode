'''
合并有序数组
author:zhangyu
date:2019.7.21
'''
from typing import List


def merge2(A: List[int], m: int, B: List[int], n: int) -> None:
    '''
        按照要求合并链表
    Args:
        A: 链表A
        m: 位置m
        B: 链表B
        n: 位置n
    '''
    A = A[:m]
    A.extend(B)
    A.sort()


def merge2(nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    '''
        按照要求合并链表
    Args:
        nums1: 链表A
        m: 位置m
        nums2: 链表B
        n: 位置n
    '''
    i, j, k = m - 1, n - 1, n + m - 1
    while i >= 0 and j >= 0:
        if nums1[i] >= nums2[j]:
            nums1[k] = nums1[i]
            i -= 1
        else:
            nums1[k] = nums2[j]
            j -= 1
        k -= 1
    while j >= 0:
        nums1[k] = nums2[j]
        j -= 1
        k -= 1
    print(nums1)
if __name__ == '__main__':
    A = [1, 2, 0, 0]
    B = [3, 6]
    merge2(A, 2, B, 2)
