# encoding='utf-8'

'''
/**
 * This is the solution of No.637 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

from tree.tree_node import TreeNode


class Solution:
    res = 0

    def path_sum(self, root: TreeNode, target_sum: int) -> int:
        '''
            路径距离
        Args:
            root: 根节点
            target_sum: 目标值
        Returns:
            得到目标值的种数
        '''
        if not root:
            return 0
        self.helper_sum(root, target_sum)
        self.path_sum(root.left, target_sum)
        self.path_sum(root.right, target_sum)
        return self.res

    def helper_sum(self, root: TreeNode, target: int) -> None:
        '''
            循环帮助类
        Args:
            root: 根节点
            target: 目标值
        Returns:
            None
        '''
        if not root:
            return
        target -= root.val
        if target == 0:
            self.res += 1
        self.helper_sum(root.left, target)
        self.helper_sum(root.right, target)


if __name__ == '__main__':
    nums = [10, 5, -3, 3, 2, None, 11, 3, -2, None, 1]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(nums)
    solution = Solution()
    result = solution.path_sum(root, 8)
    print(result)
    assert result == 3
