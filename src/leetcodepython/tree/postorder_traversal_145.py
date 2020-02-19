'''
后序遍历
author:zhangyu
date:2020.2.19
'''
from typing import List
from tree.tree_node import TreeNode


def helper(result: List[int], root: TreeNode):
    '''
        帮助方法
    Args:
        result: 结果集
        root: 根节点
    '''
    if root.left:
        helper(result, root.left)
    if root.right:
        helper(result, root.right)
    result.append(root.val)


def post_order_traversal(root: TreeNode) -> List[int]:
    '''
        后序遍历
    Args:
        res: 链表
        root: 根节点
    '''
    result = []
    if not root:
        return result
    helper(result, root)
    return result


def post_order_traversal2(root: TreeNode) -> List[int]:
    '''
        后序遍历
    Args:
        res: 链表
        root: 根节点
    '''
    result = []
    stack = []
    if len(root) < 1:
        return result
    stack.append(root)
    while len(stack) > 0:
        node = stack.pop()
        if root.left:
            stack.append(root.left)
        if root.right:
            stack.append(root.right)
        result.insert(0, node.val)
    return result
