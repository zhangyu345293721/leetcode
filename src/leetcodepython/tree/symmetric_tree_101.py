'''
/**
 * This is the solution of No.101 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/symmetric-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.tree_node import TreeNode


class Solution:
    def is_symmetric(self, root: TreeNode) -> bool:
        '''
            判断两棵树是否相同
        Args:
            root: 根节点
        Returns:
            布尔值
        '''
        if not root:
            return True
        return self.search_helper(root.left, root.right)

    def search_helper(self, t1: TreeNode, t2: TreeNode) -> bool:
        '''
            判断是否是对称二叉树
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
        if t1.val != t2.val:
            return False
        return self.search_helper(t1.left, t2.right) and self.search_helper(t1.right, t2.left)

    def is_symmetric2(self, root: TreeNode) -> bool:
        '''
            判断二叉树是否是对称
        Args:
            root: 根节点
        Returns:
            布尔值
        '''
        queue = []
        queue.append(root)
        queue.append(root)
        while queue:
            r1 = queue.pop()
            r2 = queue.pop()
            if not r1 and not r2:
                continue
            if not r1 or not r2:
                return False
            if r1.val != r2.val:
                return False
            queue.append(r1.left)
            queue.append(r2.right)
            queue.append(r1.right)
            queue.append(r2.left)
        return True


if __name__ == '__main__':
    arr1 = [1, 2, 2]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr1)
    solution = Solution()
    result = solution.is_symmetric2(root)
    print(result)
