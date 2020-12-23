'''
/**
 * This is the solution of No. 501 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List, Dict

from tree.tree_node import TreeNode
max_times = 0
current_times = 0
previous_val = None

class Solution:
    def count_times(self, time_dict: Dict[int, int], val: TreeNode) -> None:
        '''
            记录出现次数
        Args:
            time_dict: 次数字典
            val: 数字
        Returns:
            记录次数
        '''
        if val in time_dict:
            time_dict[val] += 1
        else:
            time_dict[val] = 1

    def search_helper(self, root: TreeNode, time_dict: Dict[int, int]) -> None:
        '''
            搜索帮助类
        Args:
            root: 根节点
            time_dict: 记录次数map
        Returns:
            void
        '''
        if root.left:
            self.search_helper(root.left, time_dict)
        self.count_times(time_dict, root.val)
        if root.right:
            self.search_helper(root.right, time_dict)

    def find_mode(self, root: TreeNode) -> List[int]:
        '''
            找出二叉树中出现次数最多的数
        Args:
            root: 根节点
        Returns:
            出现次数最多的数
        '''
        time_dict = {}
        if not root:
            return []
        self.search_helper(root, time_dict)

        max_value = 0
        for num in time_dict.values():
            if max_value < num:
                max_value = num
        result = []
        for pair in time_dict.items():
            if max_value == pair[1]:
                result.append(pair[0])
        return result


    def search_helper2(self, root: TreeNode, result: List[int]) -> None:
        '''
            帮助遍历查找
        Args:
            root: 根节点
            result: 结果集
        Returns:
            None
        '''
        global max_times
        global current_times
        global previous_val

        if root.left:
            self.search_helper2(root.left, result)
        if previous_val == root.val:
            current_times += 1
        else:
            previous_val = root.val
            current_times = 1

        if current_times > max_times:
            result.clear()
            result.append(root.val)
            max_times = current_times
        elif current_times == max_times:
            result.append(root.val)

        if root.right:
            self.search_helper2(root.right, result)

    def find_mode2(self, root: TreeNode) -> List[int]:
        '''
            找出频率最高的数
        Args:
            root:根节点
        Returns:
            频率出现最高的树
        '''
        result = []
        if not root:
            return []
        self.search_helper2(root, result)
        return result


if __name__ == '__main__':
    arr = [3, 2, 3, 1, 2]
    tree_node = TreeNode()
    root = tree_node.create_binary_tree_array(arr)
    solution = Solution()
    node_list = solution.find_mode2(root)
    print(node_list)
