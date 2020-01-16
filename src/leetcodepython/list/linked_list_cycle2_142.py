# encoding='utf-8'

'''
找出有环链表中的环
author:zhangyu
date:2019.8.29
'''


class ListNode:
    def __init__(self, val, next):
        self.val = val
        self.next = next


def get_detect_cycle(head: ListNode) -> ListNode:
    '''
        头结点
    Args:
        head: 头结点位置
    Returns:
        环中头结点位置
    '''
    if len(head) == None:
        return None
    slow = head
    fast = head

    while fast != None and fast.next != None:
        slow = slow.next
        fast = fast.next.next
        if fast == None:
            return None
        if slow == fast:
            break

    if fast == None or fast.next == None:
        return None
    slow = head
    while slow != fast:
        slow = slow.next
        fast = fast.next
    return slow
