'''
/**
 * This is the solution of No. 337 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/house-robber-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
from tree.tree_node import TreeNode


class Solution:
    def helper(self, node: TreeNode) -> List[int]:
        '''
            帮助方法
        Args:
            node: 节点
        Returns:
            数组
        '''
        if not node:
            return [0, 0]
        if not node.left and not node.right:
            return [node.val, 0]
        l = self.helper(node.left)
        r = self.helper(node.right)
        return [node.val + l[1] + r[1], max(r[0], r[1]) + max(l[0] + l[1])]

    def rob(self, root: TreeNode) -> int:
        '''
            找出抢劫最大值
        Args:
            root: 跟节点
        Returns:
            最大值
        '''
        result = self.helper(root)
        return max(result[0], result[1])

    def rob2(self, root: TreeNode) -> int:
        '''
            找出抢劫最大值
        Args:
            root: 跟节点
        Returns:
            最大值
        '''
        if not root:
            return 0
        val = 0
        if root.left:
            val += self.rob2(root.left.left) + self.rob2(root.left.right)
        if root.right:
            val += self.rob2(root.right.left) + self.rob2(root.right.right)
        return max(val + root.val, self.rob2(root.right) + self.rob2(root.left))


if __name__ == '__main__':
    pass
