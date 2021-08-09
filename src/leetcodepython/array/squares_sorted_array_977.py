# encoding='utf-8'

'''
/**
 * This is the solution of No. 977 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def sorted_squares(self, nums: List[int]) -> List[int]:
        '''
            排序矩形
        Args:
            nums: 数组
        Returns:
            nums
        '''
        i, j = 0, len(nums) - 1
        result = [0] * len(nums)
        idx = len(nums) - 1
        while i <= j:
            left = nums[i] * nums[i]
            right = nums[j] * nums[j]
            if left > right:
                result[idx] = left
                i += 1
            else:
                result[idx] = right
                j -= 1
            idx -= 1
        return result


if __name__ == '__main__':
    nums = [-4, -1, 0, 3, 10]
    solution = Solution()
    result = solution.sorted_squares(nums)
    print(result)
    assert result == [0, 1, 9, 16, 100]
