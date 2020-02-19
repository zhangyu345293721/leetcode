'''
二叉树在一个范围内求和
author:zhangyu
date:2020.2.10
'''
from tree.tree_node import TreeNode


def flatten(root: TreeNode) -> None:
    '''
        转换二叉树
    Args:
        root: 根节点
    Returns:
        只有有节点的二叉树
    '''
    if root == None:
        return
    stack = []
    stack.append(root)
    while len(stack) > 0:
        current_node = stack.pop()
        if current_node.right != None:
            stack.append(current_node.right)
        if current_node.left != None:
            stack.append(current_node.left)
        if len(stack) > 0:
            current_node.right = stack[-1]
        current_node.left = None


def flatten_for_list(root: TreeNode, current_node) -> TreeNode:
    '''
        循环递归树
    Args:
        root: 根节点
        current_node: 当前节点
    Returns:
        root
    '''
    if not root:
        return current_node
    current_node = flatten_for_list(root.right, current_node)
    current_node = flatten_for_list(root.left, current_node)
    root.left = None
    root.right = current_node
    return root


def flatten2(root: TreeNode) -> None:
    '''
        转换二叉树
    Args:
        root: 根节点
    Returns:
        只有有节点的二叉树
    '''
    flatten_for_list(root, None)
