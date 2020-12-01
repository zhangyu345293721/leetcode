# encoding='utf-8'

'''
/**
 * This is the solution of No. 21 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from list.list_node import ListNode


class Solution:
    def merge_two_lists(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''
            合并两个链表
        Args:
            l1: l1链表
            l2: l2链表
        Returns:
            合并后的链表
        '''
        node = ListNode(-1)
        head = node
        while l1 and l2:
            if l1.val <= l2.val:
                node.next = l1
                l1 = l1.next
            else:
                node.next = l2
                l2 = l2.next
            node = node.next
        if not l1:
            node.next = l2
        if not l2:
            node.next = l1
        return head.next


if __name__ == '__main__':
    list_node = ListNode()
    l1 = list_node.create_list_node_array([1, 2, 4])
    l2 = list_node.create_list_node_array([1, 3, 4, 5])
    solution = Solution()
    result = solution.merge_two_lists(l1, l2)
    print(result.val)
