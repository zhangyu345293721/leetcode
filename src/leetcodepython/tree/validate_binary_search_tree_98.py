'''
检验二叉树是不是BST树
author:zhangyu
'''
import sys
from tree.tree_node import TreeNode

pre = -sys.maxsize


def is_valid_BST(root: TreeNode) -> bool:
    '''
        中序遍历二叉树判断是不是BST树
    Args:
        root: 根节点
    Returns:
        布尔值
    '''
    global pre
    if not root:
        return True
    if not is_valid_BST(root.left):
        return False
    if root.val <= pre:
        return False
    pre = root.val
    return is_valid_BST(root.right)


def is_valid_BST_2(root: TreeNode) -> bool:
    '''
        中序遍历二叉树判断是不是BST树
    Args:
        root: 根节点
    Returns:
        布尔值
    '''
    pre = -sys.maxsize
    stack = []
    while not root or len(stack) < 1:
        while not root.left:
            stack.append(root.left)
            root = root.left
        # 栈退出一个元素
        root = stack.pop()

        if root.val <= pre:
            return False
        pre = root.val
        root = root.right
    return True


if __name__ == '__main__':
    nums = [2, 1, 3]
    tree = TreeNode()
    root = tree.create_binary_tree_array(nums, 0)
