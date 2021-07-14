# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.581 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 *
 * The description of problem is as follow:
 * ==========================================================================================================
  * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def shortest_unsorted_continuous_subarray(self, nums: List[int]) -> bool:
        '''
            求最短不连续子数组
        Args:
            nums: 数据
        Returns:
            不连续子数组长度
        '''
        nums_sored = sorted(nums)
        i, j = 0, len(nums) - 1
        while i < j:
            if nums[i] == nums_sored[i]:
                i += 1
            elif nums[j] == nums_sored[j]:
                j -= 1
            elif i == j:
                return 0
            else:
                return j - i + 1
        return 0

    def shortest_unsorted_continuous_subarray2(self, nums: List[int]) -> bool:
        '''
            求最短不连续子数组
        Args:
            nums: 数据
        Returns:
            不连续子数组长度
        '''
        left = len(nums)
        right = 0
        stack = []
        for i in range(len(nums)):
            while len(stack) > 1 and nums[stack[-1]] > nums[i]:
                left = min(left, stack.pop())
            stack.append(i)
        stack.clear()
        for j in reversed(range(len(nums))):
            while len(stack) > 1 and nums[stack[-1]] > nums[j]:
                right = max(right, stack.pop())
            stack.append(j)
        return 0 if right <= left else right - left + 1


if __name__ == '__main__':
    nums = [2, 6, 4, 8, 10, 9, 15]
    solution = Solution()
    result = solution.shortest_unsorted_continuous_subarray2(nums)
    print(result)
    assert result == 5
