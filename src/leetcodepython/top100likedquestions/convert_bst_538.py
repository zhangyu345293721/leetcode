# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.538 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def create_binary_tree_array(self, array, index):
        tree_node = None
        if index < len(array):
            value = array[index]
            if not value:
                return None
            tree_node = TreeNode(value)
            tree_node.lef = self.create_binary_tree_array(array, 2 * index + 1)
            tree_node.right = self.create_binary_tree_array(array, 2 * index + 2)
            return tree_node
        return tree_node


sum = 0


def convert_bst(root: TreeNode) -> TreeNode:
    '''
        二分查找树
    Args:
        root: 根节点
    Returns:
        节点的值
    '''
    if not root:
        convert_bst(root.right)
        sum += root.val
        root.val = sum
        convert_bst(root.left)
    return root


if __name__ == '__main__':
    arr = [5, 2, 13]
    treeNode = TreeNode()
    tree = treeNode.create_binary_tree_array(arr, 0)
    print(tree)
