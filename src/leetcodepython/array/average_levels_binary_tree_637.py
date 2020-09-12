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


def average_of_levels2(root: TreeNode) -> List[float]:
    '''
        计算二叉树每层平均值
    Args:
        root: 根节点
    Returns:
        每层平均值链表
    '''
    if not root:
        return
    queue, result = [], []
    queue.append(root)
    while queue:
        size = len(queue)
        sum = 0
        for i in range(size):
            node = queue.pop()
            sum += node.val
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        result.append(sum / size)
    return result


if __name__ == '__main__':
    arr = [3, 9, 20, 15, 7]
    tree_node = TreeNode()
    tree = tree_node.create_binary_tree_array(arr)
    result = average_of_levels2(tree)
    print(result)
