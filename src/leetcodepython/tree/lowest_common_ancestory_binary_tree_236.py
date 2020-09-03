'''
/**
 * This is the solution of No.236 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
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
