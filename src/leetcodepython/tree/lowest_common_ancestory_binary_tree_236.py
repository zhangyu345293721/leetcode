'''
找出最小祖先二叉树
author:zhangyu
date:2020.2.9
'''
from tree.tree_node import TreeNode


def lowest_common_ancestor(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    '''
        最小公共子节点
    Args:
        root: 节点root
        p: 节点p
        q: 节点q
    Returns:
        最小公共祖先
    '''
    if not root or not p or not q:
        return root
    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right.p, q)
    if not left and not right:
        return None
    if left and right:
        return root
    if not left:
        return right
    else:
        return left
