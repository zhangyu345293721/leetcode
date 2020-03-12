'''
将链表进行反转，递归和非递归方式
author:zhangyu
date:2020.3.10
'''


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

def reverse_list(head_a: ListNode, head_b: ListNode) -> ListNode:
    '''
        返回交点
    Args:
        head_a: 链表a
        head_b: 链表b
    Returns:
        交点
    '''
    node_list = []
    if not head_a or not head_b:
        return None
    while head_a:
        node_list.append(head_a.val)
        head_a = head_a.next
    while head_b:
        if head_b.val in node_list:
            return head_b
        head_b = head_b.next
    return None
