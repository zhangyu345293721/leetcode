# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/8/22
'''
from top100likedquestions.convert_bst_538 import TreeNode

max_deep = 0

def diameter_of_binary_tree(root: TreeNode) -> int:
    '''
        最大直径
    Args:
        root: 根节点
    Returns:
        最大深度
    '''
    global max_deep
    if not root:
        return 0
    helper(root)
    return max_deep

def helper(root: TreeNode) -> int:
    '''
        求最大直径
    Args:
        root: 根节点
    Returns:
       最大深度
    '''
    global max_deep
    if not root.left and not root.right:
        return 0
    left_deep = helper(root.left) + 1 if root.left else 0
    right_deep = helper(root.right) + 1 if root.right else 0
    max_deep = max(max_deep, left_deep + right_deep)
    return max(left_deep, right_deep)