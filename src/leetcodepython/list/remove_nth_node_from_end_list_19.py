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
    def remove_nth_from_end(self, head: ListNode, n: int) -> ListNode:
        '''
            删除倒数第n个点
        Args:
            head: 头节点
            n: 倒数n个数
        Returns:
            删除后的结果
        '''
        if head == None or head.next == None:
            return None
        dummy = ListNode(-1)
        dummy.next = head
        node1 = dummy
        node2 = dummy
        for i in range(n):
            node2 = node2.next
        while node2.next:
            node1 = node1.next
            node2 = node2.next
        node1.next = node1.next.next
        return dummy.next


if __name__ == '__main__':
    list_node = ListNode()
    l2 = list_node.create_list_node_array([1, 3, 4, 5])
    solution = Solution()
    result = solution.remove_nth_from_end(l2, 2)
    print(result.val)
    assert result.val == 1
