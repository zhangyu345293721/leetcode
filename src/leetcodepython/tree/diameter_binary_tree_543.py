# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 543 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/diameter-of-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from top100likedquestions.convert_bst_538 import TreeNode

max_deep = 0

def diameter_of_binary_tree(root: TreeNode) -> int:
    '''
        最大直径
    Args:
        root: 根节点
    Returns:
        最大深度
    '''
    global max_deep
    if not root:
        return 0
    helper(root)
    return max_deep

def helper(root: TreeNode) -> int:
    '''
        求最大直径
    Args:
        root: 根节点
    Returns:
       最大深度
    '''
    global max_deep
    if not root.left and not root.right:
        return 0
    left_deep = helper(root.left) + 1 if root.left else 0
    right_deep = helper(root.right) + 1 if root.right else 0
    max_deep = max(max_deep, left_deep + right_deep)
    return max(left_deep, right_deep)