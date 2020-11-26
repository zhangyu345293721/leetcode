'''
/**
 * This is the solution of No.234 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindrome-linked-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from list.list_node import ListNode


class Solution:
    def is_palindrome_list(self, node_list: ListNode) -> bool:
        '''
            判断链表是否是回文串
        Args:
            node_list: node链表
        Returns:
            布尔值
        '''
        i, j = 0, len(node_list) - 1
        while i < j:
            if node_list[i] != node_list[j]:
                return False
            i += 1
            j -= 1
        return True

    def is_palindrome(self, head: ListNode) -> bool:
        '''
            返回交点
        Args:
            head: 节点head
        Returns:
            布尔值
        '''
        node_list = []
        if not head:
            return True
        while head:
            node_list.append(head.val)
            head = head.next
        return self.is_palindrome_list(node_list)


if __name__ == '__main__':
    arr = [1, 2, 3, 3, 2, 1]
    list_node = ListNode()
    head = list_node.create_list_node_array(arr)
    solution = Solution()
    result = solution.is_palindrome(head)
    print(result)
