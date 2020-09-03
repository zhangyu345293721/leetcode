'''
/**
 * This is the solution of No.102 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

from tree.tree_node import TreeNode


def level_helper(res: List[List[int]], root: TreeNode, height: int):
    '''
        循环遍历二叉树
    Args:
        res: 链表
        root: 根节点
        height: 高度
    '''
    if not root:
        return
    if height >= len(res):
        return res.append([])
    res[height].append(root.val)
    level_helper(res, root.left, height + 1)
    level_helper(res, root.right, height + 1)


def level_order1(root: TreeNode) -> List[List[int]]:
    '''
        二叉树层次遍历
    Args:
        root: 跟节点
    Returns:
        层次遍历返回值
    '''
    res = []
    level_helper(res, root, 0);
    return res


def level_order2(root: TreeNode) -> List[List[int]]:
    '''
        找出抢劫最大值
    Args:
        root: 跟节点
    Returns:
        最大值
    '''
    res = []
    queue = []
    queue.append(root)
    while len(queue) > 0:
        arr = []
        size = len(queue)
        for i in range(size):
            p = queue.pop()
            arr.append(p.val)
            if p.left:
                queue.append(p.left)
            if p.right:
                queue.append(p.right)
        res.append(arr)
