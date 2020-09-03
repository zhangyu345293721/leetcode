'''
/**
 * This is the solution of No.144 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
from tree.tree_node import TreeNode


def helper(result: List[int], root: TreeNode):
    result.append(root.val)
    if root.left:
        helper(result, root.left)
    if root.right:
        helper(result, root.right)


def per_order_traversal(root: TreeNode) -> List[int]:
    '''
        先序遍历
    Args:
        res: 链表
        root: 根节点
    Returns:
        链表
    '''
    result = []
    if not root:
        return result
    helper(result, root)
    return result


def per_order_traversal2(root: TreeNode) -> List[int]:
    result = []
    if not root:
        return result
    stack = []
    stack.append(root)
    while len(stack) > 0:
        node = stack.pop()
        result.append(node.val)
        if root.right:
            stack.append(root.right)
        if root.left:
            stack.append(root.left)
    return result
