from typing import List

'''
/**
 * This is the solution of No. 560 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subarray-sum-equals-k
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def subarray_sum_equals_k(self, nums: List[int], k: int) -> int:
        '''
            找出和相同的数组
        Args:
            nums:数组
            k:固定值
        Returns:
            数组种数
        '''
        total, count, length = 0, 0, len(nums)
        for i in range(length):
            for j in range(i, length):
                total += nums[j]
                if total == k:
                    count += 1
                    total = 0
                    break
        return total

    def subarray_sum_equals_k2(self, nums: List[int], k: int) -> int:
        '''
            找出和相同的数组
        Args:
            nums:数组
            k:固定值
        Returns:
            数组种数
        '''
        count, length = 0, len(nums)
        for i in range(length):
            total = 0
            for j in range(i, length):
                total += nums[j]
                if total == k:
                    count += 1
        return count

    def subarray_sum_equals_k3(self, nums: List[int], k: int) -> int:
        '''
            找出和相同的数组
        Args:
            nums:数组
            k:固定值
        Returns:
            数组种数
        '''
        count, total = 0, 0
        map = {}
        map[0] = 1
        for i in range(len(nums)):
            total += nums[i]
            if (total - k) in map:
                count += map[total - k]
            if total not in map:
                map[total] = 1
            else:
                map[total] = map[total] + 1
        return total


if __name__ == '__main__':
    k = 2
    nums = [5, 2, 3, 1]
    solution = Solution()
    result = solution.subarray_sum_equals_k(nums, k)
    print(result)
