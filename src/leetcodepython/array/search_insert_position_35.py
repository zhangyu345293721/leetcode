# encoding='utf-8'

'''
/**
 * This is the solution of No. 35 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-insert-position
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def search_insert(self, nums: List[int], target: int) -> int:
        '''
           返回元素插入位置
       Args:
           nums: 数组
           target: 目标值
       Returns:
           返回需要插入的位置
       '''
        if not nums:
            return 0
        length = len(nums)
        if nums[length - 1] < target:
            return length
        if nums[0] >= target:
            return 0
        for i in range(0, length - 1):
            if nums[i] < target and nums[i + 1] >= target:
                return i + 1
        return -1

    def search_insert2(self, nums: List[int], target: int) -> int:
        '''
            返回元素插入位置
        Args:
            nums: 数组
            target: 目标值
        Returns:
            返回需要插入的位置
        '''
        if not nums:
            return 0
        if nums[0] >= target:
            return 0
        i, j = 0, len(nums) - 1
        while i < j:
            middle = i + (j - i) // 2
            if nums[middle] > target:
                j = middle - 1
            elif nums[middle] < target:
                if nums[middle + 1] >= target:
                    return middle + 1
                else:
                    i = middle + 1
            else:
                return middle
        if nums[j] < target:
            return j + 1
        return -1

    def search_insert3(self, nums: List[int], target: int) -> int:
        '''
            返回元素插入位置
        Args:
            nums: 数组
            target: 目标值
        Returns:
            返回需要插入的位置
        '''
        if not nums:
            return 0
        if nums[0] >= target:
            return 0
        i, j = 0, len(nums) - 1
        while i < j:
            middle = i + (j - i) // 2
            if nums[middle] > target:
                j = middle - 1
            elif nums[middle] < target:
                    i = middle + 1
            else:
                return middle
        return i


if __name__ == '__main__':
    nums = [1, 3, 5, 6]
    target = 5
    solution = Solution()
    result = solution.search_insert2(nums, target)
    print(result)
    assert result == 2
