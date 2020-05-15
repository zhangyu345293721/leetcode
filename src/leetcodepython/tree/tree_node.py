# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/3/13
'''
from typing import List


class TreeNode:
    def __init__(self, x=0):
        self.val = x
        self.left = None
        self.right = None

    def create_binary_tree_array(self, array:List[int], index=0):
        '''
            将数组构造成二叉树
        Args:
            array:数组
            index:开始下标
        Returns:
            二叉树
        '''
        tree_node = None
        if index < len(array):
            value = array[index]
            if not value:
                return None
            tree_node = TreeNode(value)
            tree_node.left = self.create_binary_tree_array(array, 2 * index + 1)
            tree_node.right = self.create_binary_tree_array(array, 2 * index + 2)
            return tree_node
        return tree_node


if __name__ == '__main__':
    arr = [5, 2, 13]
    tree_node = TreeNode()
    tree = tree_node.create_binary_tree_array(arr)
    print(tree)
