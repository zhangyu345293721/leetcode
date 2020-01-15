# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/1/14
'''


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


sum = 0


def convert_bst(root: TreeNode) -> TreeNode:
    '''
        二分查找树
    Args:
        root: 根节点
    Returns:
        节点的值
    '''
    if root != None:
        convert_bst(root.right)
        sum += root.val
        root.val = sum
        convert_bst(root.left)
    return root


if __name__ == '__main__':
    pass
