'''
二叉树层次遍历
author:zhangyu
date:2020.2.14
'''
from typing import List

from tree.tree_node import TreeNode


def level_helper(res: List[List[int]], root: TreeNode, height: int):
    '''
        循环遍历二叉树
    Args:
        res: 链表
        root: 根节点
        height: 高度
    '''
    if root == None:
        return
    if height >= len(res):
        return res.append([])
    res[height].append(root.val)
    level_helper(res, root.left, height + 1)
    level_helper(res, root.right, height + 1)


def level_order1(root: TreeNode) -> List[List[int]]:
    '''
        二叉树层次遍历
    Args:
        root: 跟节点
    Returns:
        层次遍历返回值
    '''
    res = []
    level_helper(res, root, 0);
    return res


def level_order2(root: TreeNode) -> List[List[int]]:
    '''
        找出抢劫最大值
    Args:
        root: 跟节点
    Returns:
        最大值
    '''
    res = []
    queue = []
    queue.append(root)
    while len(queue) > 0:
        arr = []
        size = len(queue)
        for i in range(size):
            p = queue.pop()
            arr.append(p.val)
            if p.left != None:
                queue.append(p.left)
            if p.right != None:
                queue.append(p.right)
        res.append(arr)
