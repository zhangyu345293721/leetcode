'''
后序遍历
author:zhangyu
date:2020.2.19
'''
from typing import List
from tree.tree_node import TreeNode


def helper(result: List[int], root: TreeNode):
    result.append(root.val)
    if root.left:
        helper(result, root.left)
    if root.right:
        helper(result, root.right)


def per_order_traversal(root: TreeNode) -> List[int]:
    '''
        先序遍历
    Args:
        res: 链表
        root: 根节点
    Returns:
        链表
    '''
    result = []
    if not root:
        return result
    helper(result, root)
    return result


def per_order_traversal2(root: TreeNode) -> List[int]:
    result = []
    if not root:
        return result
    stack = []
    stack.append(root)
    while len(stack) > 0:
        node = stack.pop()
        result.append(node.val)
        if root.right:
            stack.append(root.right)
        if root.left:
            stack.append(root.left)
    return result
