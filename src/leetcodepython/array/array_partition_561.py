'''
/**
 * This is the solution of No. 561 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/array-partition-i/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 *给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def array_pair_sum(self, nums: List[int]) -> int:
        '''
            对数组求和，分组最小
        Args:
            nums: 数组
        Returns:
            求和
        '''
        sum = 0
        nums.sort()
        i = 0
        while i < len(nums) - 1:
            min_num = min(nums[i], nums[i + 1])
            sum += min_num
            i += 2
        return sum


if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    solution = Solution()
    sum = solution.array_pair_sum(nums)
    print(sum)
    assert sum == 4
