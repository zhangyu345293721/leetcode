from typing import List


class ListNode:
    def __init__(self, x=0):
        self.val = x
        self.next = None

    def create_list_node_array(self, arr: object) -> object:
        '''
            创建list_node节点
        Args:
            arr:
            index:

        Returns:

        '''
        if not arr:
            return ListNode()
        node = ListNode(arr[0])
        head = node
        for i in range(1, len(arr)):
            node.next = ListNode(arr[i])
            node = node.next
        return head


if __name__ == '__main__':
    list_node = ListNode()
    node = list_node.create_list_node_array([1, 2, 3, 4, 5])
    print(node)
