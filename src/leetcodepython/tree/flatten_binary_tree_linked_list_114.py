'''
/**
 * This is the solution of No. 114 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.tree_node import TreeNode


class Solution:

    def flatten(self, root: TreeNode) -> None:
        '''
            转换二叉树
        Args:
            root: 根节点
        Returns:
            只有有节点的二叉树
        '''
        if root == None:
            return
        stack = []
        stack.append(root)
        while len(stack) > 0:
            current_node = stack.pop()
            if current_node.right != None:
                stack.append(current_node.right)
            if current_node.left != None:
                stack.append(current_node.left)
            if len(stack) > 0:
                current_node.right = stack[-1]
            current_node.left = None


def flatten_for_list(self, root: TreeNode, current_node) -> TreeNode:
    '''
        循环递归树
    Args:
        root: 根节点
        current_node: 当前节点
    Returns:
        root
    '''
    if not root:
        return current_node
    current_node = flatten_for_list(root.right, current_node)
    current_node = flatten_for_list(root.left, current_node)
    root.left = None
    root.right = current_node
    return root


def flatten2(self, root: TreeNode) -> None:
    '''
        转换二叉树
    Args:
        root: 根节点
    Returns:
        只有有节点的二叉树
    '''
    flatten_for_list(root, None)
