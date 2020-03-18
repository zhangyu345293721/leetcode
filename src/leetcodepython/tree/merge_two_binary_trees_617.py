'''
合并两颗二叉树
author:zhangyu
date:2020.3.18
'''
from tree.preorder_traversal_144 import per_order_traversal
from tree.tree_node import TreeNode


def merge_trees(t1: TreeNode, t2: TreeNode) -> TreeNode:
    '''
        合并两棵二叉树
    Args:
        t1: 二叉树t1
        t2: 二叉树t2
    Returns:
        合并后的二叉树
    '''
    if t1 == None:
        return t2
    if t2 == None:
        return t1
    t1.val += t2.val
    t1.left = merge_trees(t1.left, t2.left)
    t1.right = merge_trees(t1.right, t2.right)
    return t1


def merge_trees2(t1: TreeNode, t2: TreeNode) -> TreeNode:
    '''
        合并两棵二叉树
    Args:
        t1: 二叉树t1
        t2: 二叉树t2
    Returns:
        合并后的二叉树
    '''
    if t1 == None:
        return t2
    if t2 == None:
        return t1
    stack = []
    stack.append((t1, t2))
    while stack:
        t = stack.pop()
        if t[0] == None or t[1] == None:
            continue
        t[0].val += t[1].val
        if t[0].left == None:
            t[0].left = t[1].left
        else:
            stack.append((t[0].left, t[1].left))
        if t[0].right == None:
            t[0].right = t[1].right
        else:
            stack.append((t[0].right, t[1].right))
    return t1


if __name__ == '__main__':
    tree_node = TreeNode()
    t1 = tree_node.create_binary_tree_array([1, 2, 3], 0)
    t2 = tree_node.create_binary_tree_array([1, 2, 3], 0)
    t = merge_trees2(t1, t2)
    t_arr = per_order_traversal(t)
    print(t_arr)
