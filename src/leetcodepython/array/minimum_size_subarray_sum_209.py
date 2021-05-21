# encoding='utf-8'
'''
/**
 * This is the solution of No.209 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
import sys


class Solution:
    def min_sub_array_len(self, nums: List[int], target: int) -> int:
        '''
            最大数组长度
        Args:
            nums: 数组
            target: 目标值
        Returns:
            合适数据最小长度
        '''
        if not nums or len(nums) <= 0:
            return 0
        total = 0
        res = sys.maxsize
        j = 0
        for i in range(len(nums)):
            total += nums[i]
            while total >= target:
                res = min(res, i - j + 1)
                total -= nums[j]
                j += 1
        return 0 if res == sys.maxsize else res


if __name__ == '__main__':
    target = 7
    nums = [2, 3, 1, 2, 4, 3]
    solution = Solution()
    res = solution.min_sub_array_len(nums, target)
    print(res)
    assert res == 2
