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
    right = lowest_common_ancestor(root.right,p, q)
    if not left and not right:
        return None
    if left and right:
        return root
    if not left:
        return right
    else:
        return left

if __name__ == '__main__':
    nums = [3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]
    tree_node = TreeNode()
    p = TreeNode(5)
    q = TreeNode(1)
    root = tree_node.create_binary_tree_array(nums)
    result = lowest_common_ancestor(root, p, q)
    print(result)
