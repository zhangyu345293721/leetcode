# encoding='utf-8'

'''
/**
 * This is the solution of No.148 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n.logn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * 示例 1：
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from list.list_node import ListNode


class Solution:
    def sort_list(self, head: ListNode) -> ListNode:
        '''
            对链表进行排序
        Args:
            head: 节点
        Returns:
            链表
        '''
        if not head or not head.next:
            return head
        last_node = self.get_last_node(head)
        l1 = self.sort_list(head)
        l2 = self.sort_list(last_node)
        return self.merge(l1, l2)

    def get_last_node(self, node: ListNode) -> ListNode:
        '''
            获取后部分节点
        Args:
            node: node节点
        Returns:
            最后部分节点
        '''
        fast = node
        slow = node
        break_node = node
        while fast and fast.next:
            fast = fast.next.next
            break_node = slow
            slow = slow.next
        break_node.next = None
        return slow

    def merge(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''
            合并两个节点
        Args:
            l1: l1链表
            l2: l2链表
        Returns:
            合并的链表
        '''
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val <= l2.val:
            l1.next = self.merge(l1.next, l2)
            return l1
        else:
            l2.next = self.merge(l1, l2.next)
            return l2


if __name__ == '__main__':
    arr = [1, 3, 2, 5, 7, 5, 2]
    list_node = ListNode()
    node = list_node.create_list_node_array(arr)
    solution = Solution()
    result = solution.sort_list(node)
    assert result.val == 1
