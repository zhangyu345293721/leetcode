# encoding='utf-8'

'''
/**
 * This is the solution of No.2 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-two-numbers
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from list.list_node import ListNode


class Solution:
    def add_two_number(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''
            两个链表相加
        Args:
            l1: 链表l1
            l2: 链表l2
        Returns:
            链表的和
        '''
        node = ListNode(-1)
        head = node
        carry = 0
        while not l1 or not l2:
            num1 = 0 if not l1 else l1.val
            num2 = 0 if not l2 else l2.val
            total = num1 + num2 + carry
            node.next = ListNode(total % 10)
            node = node.next
            carry = total // 10
            if not l1:
                l1 = l1.next
            if not l2:
                l2 = l2.next
        if carry > 0:
            node.next = ListNode(carry)
        return head.next


if __name__ == '__main__':
    entity = ListNode()
    l1 = entity.create_list_node_array([1, 2, 3])
    l2 = entity.create_list_node_array([2, 3, 4])
    solution = Solution()
    result = solution.add_two_number(l1, l2)
    print(result)
