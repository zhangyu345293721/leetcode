'''
/**
 * This is the solution of No.145 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
from tree.tree_node import TreeNode


class Solution:
    def helper(self, result: List[int], root: TreeNode):
        '''
            帮助方法
        Args:
            result: 结果集
            root: 根节点
        '''
        if root.left:
            self.helper(result, root.left)
        if root.right:
            self.helper(result, root.right)
        result.append(root.val)

    def post_order_traversal(self, root: TreeNode) -> List[int]:
        '''
            后序遍历
        Args:
            res: 链表
            root: 根节点
        '''
        result = []
        if not root:
            return result
        self.helper(result, root)
        return result


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5]
    tree_node = TreeNode()
    tree = tree_node.create_binary_tree_array(arr)
    solution = Solution()
    result = solution.post_order_traversal(tree)
    print(result)
    assert result[len(result) - 1] == 1
