'''
/**
 * This is the solution of No.113 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/path-sum-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 * @date: 2020/9/26
 */
'''
from typing import List

from tree.tree_node import TreeNode


def path_sum_helper(res: List[int], root: TreeNode, temp: List[int], sum: int) -> None:
    '''
        遍历求和递归帮助类
    Args:
        res: 结果链表
        root: 根节点
        temp: 临时节点
        sum:  结果集和
    Returns:
        None
    '''
    temp.append(root.val)
    sum = sum - root.val
    if not root.left and not root.right and sum == 0:
        res.append(list(temp))
    if root.left:
        path_sum_helper(res, root.left, temp, sum)
    if root.right:
        path_sum_helper(res, root.right, temp, sum)
    temp.pop(-1)


def path_sum(root: TreeNode, sum: int) -> List[List[int]]:
    '''
        路径之和
    Args:
        root: 跟节点
        sum: 总共和
    Returns:
        结果集合
    '''
    result = []
    temp = []
    if not root:
        return result
    path_sum_helper(result, root, temp, sum)
    return result


if __name__ == '__main__':
    arr = [5, 4, 8, 11, None, 13, 4, 7, 2, None, None, None, None, 5, 1]
    sum = 22
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr)
    sum_list = path_sum(root, sum)
    print(sum_list)
