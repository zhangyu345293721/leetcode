'''
二叉树在一个范围内求和
author:zhangyu
date:2020.1.16
'''
from tree.tree_node import TreeNode, create_binary_tree_by_array


def dfs_search_tree(node: TreeNode, L: int, R: int, ans: int) -> None:
    '''
        递归求值
    Args:
        root: 根节点
        L: 最小值
        R: 最大值
    '''
    if node :
        if L <= node.val and node.val <= R:
            ans += node.val
        if L < node.val:
            dfs_search_tree(node.left, L, R)
        if node.val < R:
            dfs_search_tree(node.right, L, R)


def range_sum_bst(root: TreeNode, L: int, R: int) -> int:
    '''
        求和取最大数
    Args:
        root: 根节点
        L: 最小值
        R: 最大值
    Returns:
        求和
    '''
    ans = 0
    dfs_search_tree(root, L, R, ans)
    return ans


if __name__ == '__main__':
    arr = [10, 5, 15, 3, 7, None, 18]
    tree_node = create_binary_tree_by_array(arr, 0)
    total_sum = range_sum_bst(tree_node, 7, 15)
    print(total_sum)
