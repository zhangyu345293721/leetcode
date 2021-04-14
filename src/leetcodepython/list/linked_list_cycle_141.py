# encoding='utf-8'

'''
/**
 * This is the solution of No.141 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/linked-list-cycle
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from list.list_node import ListNode


class Solution:
    def has_cycle_1(self, head: ListNode) -> ListNode:
        '''
            寻找链表里面的环
        Args:
            head: 头结点
        Returns:
            bool
        '''
        node_set = set()
        while head:
            if head in node_set:
                return True
            else:
                node_set.add(head)
            head = head.next
        return False

    def has_cycle_2(self, head: ListNode) -> ListNode:
        '''
            寻找链表里面的环
        Args:
            head: 头结点
        Returns:
            bool
        '''
        if head == None or head.next == None:
            return False
        fast = head.next
        slow = head
        while slow != fast:
            if head == None or head.next == None:
                return False
            slow = slow.next
            fast = fast.next.next
        return True


if __name__ == '__main__':
    arr = [1, 3, 2, 5, 7, 5, 2]
    list_node = ListNode()
    node = list_node.create_list_node_array(arr)
    solution = Solution()
    result = solution.has_cycle_1(node)
    assert result == False
