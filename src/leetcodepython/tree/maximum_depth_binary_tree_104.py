'''
/**
 * This is the solution of No. 104 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *  3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''

from tree.tree_node import TreeNode


class Solution:
    def max_depth(self, root: TreeNode) -> int:
        '''
            最大深度
        Args:
            root:根节点
        Returns:
            最大深度
        '''
        if root == None:
            return 0
        return max(self.max_depth(root.left), self.max_depth(root.right)) + 1

    def max_depth_2(self, root: TreeNode) -> int:
        '''
            最大深度
        Args:
            root:根节点
        Returns:
            最大深度
        '''
        stack = []
        if root:
            stack.append((root, 1))
        depth = 0
        while stack:
            current = stack.pop()
            root, current_depth = current[0], current[1]
            if root:
                depth = max(depth, current_depth)
                stack.append((root.left, current_depth + 1))
                stack.append((root.right, current_depth + 1))
        return depth


if __name__ == '__main__':
    arr = [3, 9, 20, None, None, 15, 7]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr)
    solution = Solution()
    result = solution.max_depth_2(root)
    print(result)
    assert result == 3
