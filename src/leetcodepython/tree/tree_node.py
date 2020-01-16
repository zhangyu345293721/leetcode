'''
建二叉树
author:zhangyu
date:2020.1.16
'''
from typing import List


class TreeNode:
    def __int__(self, x):
        self.val = x
        self.left = None
        self.right = None


def create_binary_tree_by_array(arr: List[object], index=0) -> TreeNode:
    '''
        把数组构建成二叉树
    Args:
        arr:数组
        index:开始下标
    Returns:
        构建的二叉树
    '''
    tn = None
    if index < len(arr):
        if arr[index] == None:
            return None
        tn = TreeNode(arr[index])
        tn.left = create_binary_tree_by_array(arr, 2 * index + 1)
        tn.right = create_binary_tree_by_array(arr, 2 * index + 2)
        return tn
    return tn