'''
/**
 * This is the solution of No.617 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-two-binary-trees
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.preorder_traversal_144 import per_order_traversal
from tree.tree_node import TreeNode


def merge_trees(t1: TreeNode, t2: TreeNode) -> TreeNode:
    '''
        合并两棵二叉树
    Args:
        t1: 二叉树t1
        t2: 二叉树t2
    Returns:
        合并后的二叉树
    '''
    if t1 == None:
        return t2
    if t2 == None:
        return t1
    t1.val += t2.val
    t1.left = merge_trees(t1.left, t2.left)
    t1.right = merge_trees(t1.right, t2.right)
    return t1


def merge_trees2(t1: TreeNode, t2: TreeNode) -> TreeNode:
    '''
        合并两棵二叉树
    Args:
        t1: 二叉树t1
        t2: 二叉树t2
    Returns:
        合并后的二叉树
    '''
    if t1 == None:
        return t2
    if t2 == None:
        return t1
    stack = []
    stack.append((t1, t2))
    while stack:
        t = stack.pop()
        if t[0] == None or t[1] == None:
            continue
        t[0].val += t[1].val
        if t[0].left == None:
            t[0].left = t[1].left
        else:
            stack.append((t[0].left, t[1].left))
        if t[0].right == None:
            t[0].right = t[1].right
        else:
            stack.append((t[0].right, t[1].right))
    return t1


if __name__ == '__main__':
    tree_node = TreeNode()
    t1 = tree_node.create_binary_tree_array([1, 2, 3], 0)
    t2 = tree_node.create_binary_tree_array([1, 2, 3], 0)
    t = merge_trees2(t1, t2)
    t_arr = per_order_traversal(t)
    print(t_arr)
