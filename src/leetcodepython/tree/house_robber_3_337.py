'''
二叉树在一个范围内求和
author:zhangyu
date:2020.2.13
'''
from typing import List
from tree.tree_node import TreeNode


def helper(node: TreeNode) -> List[int]:
    '''
        帮助方法
    Args:
        node: 节点
    Returns:
        数组
    '''
    if not node:
        return [0, 0]
    if not node.left and not node.right:
        return [node.val, 0]
    l = helper(node.left)
    r = helper(node.right)
    return [node.val + l[1] + r[1], max(r[0], r[1]) + max(l[0] + l[1])]


def rob(root: TreeNode) -> int:
    '''
        找出抢劫最大值
    Args:
        root: 跟节点
    Returns:
        最大值
    '''
    result = helper(root)
    return max(result[0], result[1])


def rob2(root: TreeNode) -> int:
    '''
        找出抢劫最大值
    Args:
        root: 跟节点
    Returns:
        最大值
    '''
    if not root:
        return 0
    val = 0
    if root.left:
        val += rob2(root.left.left) + rob2(root.left.right)
    if root.right:
        val += rob2(root.right.left) + rob2(root.right.right)
    return max(val + root.val, rob2(root.right) + rob2(root.left))
