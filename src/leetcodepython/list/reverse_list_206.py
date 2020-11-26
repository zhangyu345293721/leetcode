# encoding='utf-8'

'''
/**
 * This is the solution of No. 206 problem in the LeetCode,
 * the website of the problem is as follow:
 *https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 反转一个单链表。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from list.list_node import ListNode


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


def reverse_list3(head: ListNode) -> ListNode:
    '''
        反转链表(非递归方式)
    Args:
        head: 头结点位置
    Returns:
        头节点
    '''
    cur, pre, temp = head, None, None
    while cur:
        cur.next, pre, cur = pre, cur, cur.next
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
