# encoding='utf-8'

'''
/**
 * This is the solution of No.142 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class ListNode:
    def __init__(self, val, next):
        self.val = val
        self.next = next


def detect_cycle(head: ListNode) -> ListNode:
    '''
        头结点
    Args:
        head: 头结点位置
    Returns:
        环中头结点位置
    '''
    if not head or not head.next:
        return None
    slow = head
    fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if fast == None:
            return None
        if slow == fast:
            break
    if not fast or not fast.next:
        return None
    slow = head
    while slow != fast:
        slow = slow.next
        fast = fast.next
    return slow


def detect_cycle_2(head: ListNode) -> ListNode:
    '''
        头结点
    Args:
        head: 头结点位置
    Returns:
        环中头结点位置
    '''
    if not head or not head.next:
        return None
    node = ListNode(-1)
    node.next = head
    cur = node
    list_node_set = set()
    while cur.next:
        if cur.next in list_node_set:
            return cur.next
        cur = cur.next
        list_node_set.add(cur)
    return None
