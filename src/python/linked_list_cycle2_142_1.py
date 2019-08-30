# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.29
   description:找出有环链表中的环
'''


class ListNode:
    def __init__(self, val, next):
        self.val = val
        self.next = next


def get_detect_cycle(head):
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
