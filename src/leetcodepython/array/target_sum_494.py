# encoding='utf-8'

'''
/**
 * This is the solution of No. 226 problem in the LeetCode,
 * the website of the problem is as follow:
 * ttps://leetcode-cn.com/problems/invert-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the root of a binary tree, invert the tree, and return its root.
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *  
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    num = 0

    def find_target_sum_ways(self, nums: List[int], S: int) -> int:
        '''
            获取目标值的方法
        Args:
            nums: 数组
            S: 目标值
        Returns:
            组合的次数
        '''
        self.dfs(0, nums, 0, S)
        return self.num

    def dfs(self, i: int, nums: List[int], total: int, target: int):
        '''
            深度优先遍历
        Args:
            i: 下标i
            nums: 数组
            total: 和
            target: 目标值
        Returns:
            None
        '''
        if i == len(nums):
            if target == total:
                self.num += 1
        else:
            self.dfs(i + 1, nums, total + nums[i], target)
            self.dfs(i + 1, nums, total - nums[i], target)


if __name__ == '__main__':
    arr = [4, 2, 7, 1, 3, 6, 9]
    solution = Solution()
    result = solution.find_target_sum_ways(arr, 20)
    print(result)
    assert 3 == result
