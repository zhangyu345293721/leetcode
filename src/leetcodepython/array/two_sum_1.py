# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/two-sum
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def two_sum(self, nums: List[int], target: int) -> int:
        '''
            计算组成和下标
        Args:
            nums: 数组
            target: 目标值
        Returns:
            目标值下标
        '''
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return [-1, -1]

    def two_sum2(self, nums: List[int], target: int) -> int:
        '''
            计算组成和下标
        Args:
            nums: 数组
            target: 目标值
        Returns:
            目标值下标
        '''
        nums_dict = {}
        for i in range(len(nums)):
            if (target - nums[i]) in nums_dict:
                return [nums_dict[target - nums[i]], i]
            else:
                nums_dict[nums[i]] = i
        return [-1, -1]


if __name__ == '__main__':
    arr = [2, 5, 7, 11]
    target = 7
    solution = Solution()
    result = solution.two_sum(arr, target)
    assert result == [0, 1]
