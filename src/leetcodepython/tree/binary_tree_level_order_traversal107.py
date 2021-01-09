'''
/**
 * This is the solution of No.107 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

from tree.tree_node import TreeNode


class Solution:

    def level_order_bottom(self, root: TreeNode) -> List[List[int]]:
        '''
            链表倒序遍历
        Args:
            root:根节点
        Returns:
            逆序排序层次遍历
        '''
        level_order_reverse_list = []
        if not root:
            return level_order_reverse_list
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            node_list = []
            for i in range(size):
                node = queue.pop(0)
                node_list.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            level_order_reverse_list.insert(0, node_list)
        return level_order_reverse_list


if __name__ == '__main__':
    arr = [3, 9, 20, None, None, 15, 7]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr)
    solution = Solution()
    node_list = solution.level_order_bottom(root)
    print(node_list)
    assert node_list == [[15, 7], [9, 20], [3]]
