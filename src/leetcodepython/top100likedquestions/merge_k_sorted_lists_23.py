# encoding='utf-8'

'''
合并链表
author:zhangyu
date:2020.1.9
'''
from typing import List

from list.linked_list_cycle2_142 import ListNode



def helper(lists: List[ListNode], l: int, r: int) -> ListNode:
    '''
        递归帮助类
    Args:
        lists: 链表
        l: 坐标
        r: 右边
    Returns:
       合并后链表
    '''
    if l == r:
        return lists[l]
    mid = (l + r) / 2
    return merge(helper(lists, l, mid), helper(lists, mid + 1, r))


def merge_k_list(lists: List[ListNode]) -> ListNode:
    '''
        熟悉合并链表
    Args:
        lists:链表
    Returns:
        合并后的list
    '''
    if not lists:
        return None
    return helper(lists, 0, len(lists) - 1)

def merge(l1: ListNode, l2: ListNode) -> ListNode:
    dummy = ListNode(0)
    tail = dummy
    while l1 != None and l2 != None:
        if l1.val < l2.val:
            tail.next = l1
            l1 = l1.next
        else:
            tail.next = l2
            l2 = l2.next
        tail = tail.next
    if l1 != None:
        tail.next = l1
    if l2 != None:
        tail.next = l2
    return dummy.next