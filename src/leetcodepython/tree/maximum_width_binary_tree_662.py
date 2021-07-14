'''
/**
 * This is the solution of No. 104 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from tree.tree_node import TreeNode


class Solution:
    def width_of_binary_tree(self, root: TreeNode) -> int:
        '''
            树的宽度
        Args:
            root: 根节点
        Returns:
            树的最大宽度
        '''
        if not root:
            return 0
        result = 0
        queue = []
        queue_index = []
        queue.append(root)
        queue_index.append(1)
        while len(queue) > 0:
            level_size = len(queue)
            init_index = queue_index[0]
            i = init_index
            while level_size > 0:
                r = queue.pop(0)
                i = queue_index.pop(0)
                if r.left:
                    queue.append(r.left)
                    queue_index.append(i * 2)
                if r.right:
                    queue.append(r.right)
                    queue_index.append(i * 2 + 1)
                level_size -= 1
            result = max(result, i - init_index + 1)
        return result


if __name__ == '__main__':
    arr = [3, 2, 3, None, 3, None, 1]
    node = TreeNode.create_binary_tree_array(arr)
    solution = Solution()
    result = solution.width_of_binary_tree(node)
    print(result)
    assert result == 3
