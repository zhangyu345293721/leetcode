# encoding='utf-8'

'''
/**
 * This is the solution of No. 258 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-digits/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * 来源：力扣（LeetCode）
 ** ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def remove_duplicates(self, nums: List[int]) -> int:
        '''
            移除重复的数字
        Args:
            nums: 数组
        Returns:
            重复数
        '''
        if nums == None or len(nums) < 1:
            return 0
        idx = 0
        for i in range(1, len(nums)):
            if nums[idx] != nums[i]:
                idx += 1
                nums[idx] = nums[i]
        return idx + 1


if __name__ == '__main__':
    nums = [1, 1, 2]
    solution = Solution()
    result = solution.remove_duplicates(nums)
    print(result)
    assert result == 2
