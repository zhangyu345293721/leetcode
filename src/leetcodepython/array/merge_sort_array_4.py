'''
/**
 * This is the solution of No. 4 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def find_median_sorted_arrays(self, nums1: List[int], nums2: List[int]) -> float:
        '''
            查找中间数
        Args:
            nums1: 数组1
            nums2: 数组2
        Returns:
            计算中间数的值
        '''
        length1 = len(nums1)
        length2 = len(nums2)
        length = length1 + length2
        nums = [0] * length
        i, j, index = 0, 0, 0
        while i < length1 and j < length2:
            if nums1[i] <= nums2[j]:
                nums[index] = nums1[i]
                i += 1
            else:
                nums[index] = nums2[j]
                j += 1
            index += 1
        if i == length1:
            while j < length2:
                nums[index] = nums2[j]
                j += 1
                index += 1
        if j == length2:
            while i < length1:
                nums[index] = nums1[i]
                i += 1
                index += 1
        if length % 2 == 0:
            return (nums[length // 2] + nums[length // 2 - 1]) / 2.0
        else:
            return nums[length // 2]


if __name__ == '__main__':
    nums1 = [1, 2]
    nums2 = [3, 4]
    solution = Solution()
    result = solution.find_median_sorted_arrays(nums1, nums2)
    assert result == 2.5
