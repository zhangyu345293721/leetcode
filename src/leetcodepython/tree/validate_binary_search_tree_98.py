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
import sys
from tree.tree_node import TreeNode

pre = -sys.maxsize


class Solution:

    def is_valid_BST(self, root: TreeNode) -> bool:
        '''
            中序遍历二叉树判断是不是BST树
        Args:
            root: 根节点
        Returns:
            布尔值
        '''
        global pre
        if not root:
            return True
        if not self.is_valid_BST(root.left):
            return False
        if root.val <= pre:
            return False
        pre = root.val
        return self.is_valid_BST(root.right)

    def is_valid_BST_2(self, root: TreeNode) -> bool:
        '''
            中序遍历二叉树判断是不是BST树
        Args:
            root: 根节点
        Returns:
            布尔值
        '''
        pre = -sys.maxsize
        stack = []
        while not root or len(stack) < 1:
            while not root.left:
                stack.append(root.left)
                root = root.left
            # 栈退出一个元素
            root = stack.pop()
            if root.val <= pre:
                return False
            pre = root.val
            root = root.right
        return True


if __name__ == '__main__':
    nums = [2, 1, 3]
    tree = TreeNode()
    root = tree.create_binary_tree_array(nums)
    solution = Solution()
    result = solution.is_valid_BST(root)
    assert result == True
