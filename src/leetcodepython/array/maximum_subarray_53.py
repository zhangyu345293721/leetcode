# encoding='utf-8'

'''
/**
 * This is the solution of No.53 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-subarray
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def max_sub_array(self, nums: List[int]) -> int:
        '''
            获取到连续子数组最大值
        Args:
            nums:数组
        Returns:
            最大值
        '''
        result, max_value = nums[0], 0
        for i in range(1, len(nums)):
            if result < 0:
                result = nums[i]
            else:
                result += nums[i]
                max_value = max(result, max_value)
        return max_value

    def max_sub_array2(self, nums: List[int]) -> int:
        '''
            获取到连续子数组最大值
        Args:
            nums:数组
        Returns:
            最大值
        '''
        if not nums:
            return 0
        result, sum_value = nums[0], nums[0]
        for i in range(1, len(nums)):
            sum_value = max(sum_value + nums[i], nums[i])
            result = max(result, sum_value)
        return result


if __name__ == '__main__':
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    solution = Solution()
    result = solution.max_sub_array2(nums)
    assert result == 6
