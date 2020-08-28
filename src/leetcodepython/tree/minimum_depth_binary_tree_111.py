# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/8/22
'''
from tree.tree_node import TreeNode


def min_depth(root: TreeNode) -> int:
    '''
        计算一个二叉树最小深度
    Args:
        root: 根节点
    Returns:
        最小深度
    '''
    if not root:
        return 0
    if not root.left and root.right:
        return 1 + min_depth(root.right)
    if not root.right and root.left:
        return 1 + min_depth(root.left)
    return 1 + min(min_depth(root.left), min_depth(root.right))


if __name__ == '__main__':
    arr = [3, 9, 20, None, None, 15, 7]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr)
    min_deep = min_depth(root)
    print(min_deep)
