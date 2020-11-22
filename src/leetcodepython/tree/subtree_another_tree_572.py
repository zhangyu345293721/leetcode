'''
/**
 * This is the solution of No.98 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/validate-binary-search-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.tree_node import TreeNode


class Solution:
    def is_same(self, t1: TreeNode, t2: TreeNode) -> bool:
        '''
            判断两棵树是否相同
        Args:
            t1: 二叉树t1
            t2: 二叉树t2
        Returns:
            布尔值
        '''
        if not t1 and not t2:
            return True
        if not t1 or not t2:
            return False
        if t1.val == t2.val:
            return self.is_same(t1.left, t2.left) and self.is_same(t1.right, t2.right)
        else:
            return False

    def is_subtree(self, s: TreeNode, t: TreeNode) -> bool:
        '''
            判断是否是子树
        Args:
            s: 二叉树s
            t: 二叉树t
        Returns:
            布尔值
        '''
        if not s:
            return False
        if s.val == t.val and self.is_same(s, t):
            return True
        return self.is_subtree(s.left, s) or self.is_subtree(s.right, s)


if __name__ == '__main__':
    arr1 = [1, 2, 3]
    arr2 = [1, 2, 3]
    tree_node = TreeNode()
    s = tree_node.create_binary_tree_array(arr1)
    t = tree_node.create_binary_tree_array(arr2)
    solution = Solution()
    result = solution.is_subtree(s, t)
    print(result)
