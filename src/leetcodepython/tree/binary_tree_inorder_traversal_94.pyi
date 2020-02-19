'''
二叉树中序遍历
author:zhangyu
date:2020.2.16
'''
from typing import List

from tree.tree_node import TreeNode


def helper(res: List[int], root: TreeNode):
    '''
        中序遍历二叉树
    Args:
        res: 链表
        root: 根节点
    '''
    if root.left != None:
        helper(res, root.left)
    res.append(root.val)
    if root.right != None:
        helper(res, root.right)


def inorder_traversal1(root: TreeNode) -> List[int]:
    '''
        中序遍历二叉树
    Args:
        root: 跟节点
    Returns:
        中序递归遍历二叉树
    '''
    result = []
    if root == None:
        return result
    helper(result, root);
    return result


def inorder_traversal2(root: TreeNode) -> List[int]:
    '''
        中序遍历二叉树
    Args:
        root: 跟节点
    Returns:
        中序递归遍历二叉树
    '''
    result, stack = [], []
    while root or stack:
        if root:
            stack.append(root)
            root = root.left
        else:
            node = stack.pop()
            result.append(node.val)
            root = node.right
    return result
