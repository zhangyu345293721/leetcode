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


class Solution:
    def reverse_list(self, head: ListNode) -> ListNode:
        '''
            反转链表（递归方式）
        Args:
            head: 头结点位置
        Returns:
            头节点
        '''
        if not head or not head.next:
            return head
        pre = self.reverse_list(head.next)
        head.next.next = head
        head.next = None
        return pre

    def reverse_list2(self, head: ListNode) -> ListNode:
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

    def reverse_list3(self, head: ListNode) -> ListNode:
        '''
            反转链表(非递归方式)
        Args:
            head: 头结点位置
        Returns:
            头节点
        '''
        cur, pre = head, None
        while cur:
            cur.next, pre, cur = pre, cur, cur.next
        return pre


if __name__ == '__main__':
    node1 = ListNode.create_list_node_array([1, 2, 3, 4, 5])
    solution = Solution()
    node = solution.reverse_list2(node1)
    print(node.val)
    assert node.val == 5
