class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def middle_linked_list(head: ListNode) -> ListNode:
    '''
        找出中间结点
    Args:
        head: 头结点
    Returns:
        中间结点
    '''
    if not head or not head.next:
        return head
    slow, fast = head, head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    return slow


def middle_linked_list2(head: ListNode) -> ListNode:
    '''
       找出中间结点
   Args:
       head: 头结点
   Returns:
       中间结点
   '''
    if not head or not head.next:
        return head
    count = 0
    temp = head
    while temp:
        count += 1
        temp = temp.next
    for i in range(count // 2):
        head = head.next
    return head


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
    node = middle_linked_list(node1)
    print(node.val)
