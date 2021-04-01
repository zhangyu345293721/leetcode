# encoding='utf-8'

'''
/**
 * This is the solution of No. 226 problem in the LeetCode,
 * the website of the problem is as follow:
 * ttps://leetcode-cn.com/problems/invert-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the root of a binary tree, invert the tree, and return its root.
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *  
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.tree_node import TreeNode


class Solution:
    def invert_tree(self, root: TreeNode) -> TreeNode:
        '''
            翻转二叉树
        Args:
            root: 根节点
        Returns:
            TreeNode
        '''
        if root == None:
            return None
        left = self.invert_tree(root.left)
        right = self.invert_tree(root.right)
        root.left = right
        root.right = left
        return root

    def invert_tree2(self, root: TreeNode) -> TreeNode:
        '''
            翻转二叉树
        Args:
            root: 根节点
        Returns:
            TreeNode
        '''
        if root == None:
            return None
        node_list = []
        node_list.append(root)
        while len(node_list) > 0:
            cur = node_list.pop()
            if cur.left:
                node_list.append(cur.left)
            if cur.right:
                node_list.append(cur.right)
            temp = cur.right
            cur.right = cur.left
            cur.left = temp
        return root


if __name__ == '__main__':
    arr = [4, 2, 7, 1, 3, 6, 9]
    root = TreeNode.create_binary_tree_array(arr)
    solution = Solution()
    result = solution.invert_tree(root)
    assert 4 == result.val
