# encoding='utf-8'

'''
/**
 * This is the solution of No. 128 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-consecutive-sequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def longest_consecutive(self, nums: List[int]) -> List[int]:
        '''
            找出最大连续子串
        Args:
            nums: 数组

        Returns:
            连续子串长度
        '''
        if len(nums) <= 1:
            return len(nums)
        nums.sort()
        max_length, count = 1, 1
        for i in range(len(nums) - 1):
            if nums[i] + 1 == arr[i + 1]:
                count += 1
            else:
                if nums[i] != nums[i + 1]:
                    count = 1
            max_length = max(count, max_length)
        return max_length

    def longest_consecutive_2(nums: List[int]) -> int:
        '''
            找出最大的连续子串
        Args:
            nums: 数组
        Returns:
            最大子串长度
        '''
        if len(nums) <= 1:
            return len(nums)
        count = 0
        num_set = set(nums)
        for num in num_set:
            if num-1 not in num_set:
                current_count = 1
                current_num = num
                while current_num + 1 in nums:
                    current_count += 1
                    current_num += 1
                count = max(count, current_count)
        return count


if __name__ == '__main__':
    arr = [2, 1, 3, 3, 4]
    solution = Solution()
    max_length = solution.longest_consecutive(arr)
    print(max_length)
    assert max_length == 4
