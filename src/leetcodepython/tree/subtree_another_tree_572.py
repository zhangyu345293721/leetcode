'''
/**
 * This is the solution of No.572 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subtree-of-another-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        return self.is_subtree(s.left, t) or self.is_subtree(s.right, t)


if __name__ == '__main__':
    arr1 = [1, 2, 3]
    arr2 = [1, 2, 3]
    tree_node = TreeNode()
    s = tree_node.create_binary_tree_array(arr1)
    t = tree_node.create_binary_tree_array(arr2)
    solution = Solution()
    result = solution.is_subtree(s, t)
    assert result == True
