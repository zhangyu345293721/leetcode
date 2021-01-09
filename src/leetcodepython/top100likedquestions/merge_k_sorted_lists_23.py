# encoding='utf-8'

'''
/**
 * This is the solution of No.23 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

from list.linked_list_cycle2_142 import ListNode


class Solution:

    def helper(self, lists: List[ListNode], l: int, r: int) -> ListNode:
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
        return self.merge(self.helper(lists, l, mid), self.helper(lists, mid + 1, r))

    def merge_k_list(self, lists: List[ListNode]) -> ListNode:
        '''
            熟悉合并链表
        Args:
            lists:链表
        Returns:
            合并后的list
        '''
        if not lists:
            return None
        return self.helper(lists, 0, len(lists) - 1)

    def merge(self, l1: ListNode, l2: ListNode) -> ListNode:
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
