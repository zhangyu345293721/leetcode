# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/14
'''


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    @staticmethod
    def create_binary_tree_array(self, array, index):
        tree_node = None
        if index < len(array):
            value = array[index]
            if not value:
                return None
            tree_node = TreeNode(value)
            tree_node.lef = self.create_binary_tree_array(array, 2 * index + 1)
            tree_node.right = self.create_binary_tree_array(array, 2 * index + 2)
            return tree_node
        return tree_node


sum = 0


def convert_bst(root: TreeNode) -> TreeNode:
    '''
        二分查找树
    Args:
        root: 根节点
    Returns:
        节点的值
    '''
    if not root:
        convert_bst(root.right)
        sum += root.val
        root.val = sum
        convert_bst(root.left)
    return root


if __name__ == '__main__':
    arr = [5, 2, 13]
    tree = TreeNode.create_binary_tree_array(arr, 0)
    print(tree)
