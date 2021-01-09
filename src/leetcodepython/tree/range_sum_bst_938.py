'''
/**
 * This is the solution of No.938 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/range-sum-of-bst
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.tree_node import TreeNode


class Solution:

    def dfs_search_tree(self, node: TreeNode, L: int, R: int, ans: int) -> None:
        '''
            递归求值
        Args:
            root: 根节点
            L: 最小值
            R: 最大值
        '''
        if node:
            if L <= node.val and node.val <= R:
                ans += node.val
            if L < node.val:
                self.dfs_search_tree(node.left, L, R)
            if node.val < R:
                self.dfs_search_tree(node.right, L, R)

    def range_sum_bst(self, root: TreeNode, L: int, R: int) -> int:
        '''
            求和取最大数
        Args:
            root: 根节点
            L: 最小值
            R: 最大值
        Returns:
            求和
        '''
        ans = 0
        self.dfs_search_tree(root, L, R, ans)
        return ans


if __name__ == '__main__':
    arr = [10, 5, 15, 3, 7, None, 18]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr)
    solution = Solution()
    total_sum = solution.range_sum_bst(root, 7, 15)
    print(total_sum)
    assert total_sum == 45
