# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 167 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def two_sum(self, nums: List[int], target: int) -> int:
        '''
            找到数字的下标
        Args:
            nums: 数组
            target: 目标值
        Returns:
            下标数组
        '''
        i = 0
        j = len(nums) - 1
        while i < j:
            if nums[i] + nums[j] < target:
                i += 1
            elif nums[i] + nums[j] > target:
                j -= 1
            else:
                return [i + 1, j + 1]
        return [-1, -1]


if __name__ == '__main__':
    arr = [2, 5, 7, 11]
    target = 7
    solution = Solution()
    result = solution.two_sum(arr, target)
    print(result)
    assert result == [1, 2]
