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


if __name__ == '__main__':
    A = [1, 2, 0, 0]
    B = [3, 6]
    merge2(A, 2, B, 1)
