from typing import List


class ListNode:
    def __init__(self, x=0):
        self.val = x
        self.next = None

    def create_list_node_array(self, nums: object) -> object:
        '''
            创建list_node节点
        Args:
            nums:数组
            index:下标
        Returns:
             ListNode链表
        '''
        if not nums:
            return ListNode()
        node = ListNode(nums[0])
        head = node
        for i in range(1, len(nums)):
            node.next = ListNode(nums[i])
            node = node.next
        return head


if __name__ == '__main__':
    list_node = ListNode()
    node = list_node.create_list_node_array([1, 2, 3, 4, 5])
    print(node)
