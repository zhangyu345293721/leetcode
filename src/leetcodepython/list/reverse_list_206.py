# encoding='utf-8'

'''
将链表进行反转，递归和非递归方式
author:zhangyu
date:2020.3.2
'''


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def reverse_list(head: ListNode) -> ListNode:
    '''
        反转链表（递归方式）
    Args:
        head: 头结点位置
    Returns:
        头节点
    '''
    if not head or not head.next:
        return head
    node = reverse_list(head.next)
    head.next.next = head
    head.next = None
    return node


def reverse_list2(head: ListNode) -> ListNode:
    '''
        反转链表(非递归方式)
    Args:
        head: 头结点位置
    Returns:
        头节点
    '''
    cur, pre, temp = head, None, None
    while cur:
        temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    return pre


if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(3)
    node4 = ListNode(4)
    node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node = reverse_list2(node1)
    print(node)
