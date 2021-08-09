'''
/**
 * This is the solution of No.160 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 * 在节点 c1 开始相交。
 *
 * 示例 1：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

'''
from list.list_node import ListNode


class Solution:
    def get_intersection_node(self, head_a: ListNode, head_b: ListNode) -> ListNode:
        '''
            返回交点
        Args:
            head_a: 链表a
            head_b: 链表b
        Returns:
            交点
        '''
        if not head_a or not head_b:
            return None
        p_A = head_a
        p_B = head_b
        while p_A != p_B:
            p_A = head_b if not p_A else p_A.next
            p_B = head_a if not p_B else p_B.next
        return p_A

if __name__ == '__main__':
    arr1 = [4, 1, 8, 4, 5]
    l1 = ListNode.create_list_node_array(arr1)
    arr2 = [5, 0, 1, 8, 4, 5]
    l2 = ListNode.create_list_node_array(arr2)
    solution = Solution()
    result = solution.get_intersection_node(l1, l2)
    print(result)
    assert result == None
