'''
/**
 * This is the solution of No.94 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

from tree.tree_node import TreeNode


def helper(res: List[int], root: TreeNode):
    '''
        中序遍历二叉树
    Args:
        res: 链表
        root: 根节点
    '''
    if root.left != None:
        helper(res, root.left)
    res.append(root.val)
    if root.right != None:
        helper(res, root.right)


def inorder_traversal1(root: TreeNode) -> List[int]:
    '''
        中序遍历二叉树
    Args:
        root: 跟节点
    Returns:
        中序递归遍历二叉树
    '''
    result = []
    if root == None:
        return result
    helper(result, root);
    return result


def inorder_traversal2(root: TreeNode) -> List[int]:
    '''
        中序遍历二叉树
    Args:
        root: 跟节点
    Returns:
        中序递归遍历二叉树
    '''
    result, stack = [], []
    while root or stack:
        if root:
            stack.append(root)
            root = root.left
        else:
            node = stack.pop()
            result.append(node.val)
            root = node.right
    return result
