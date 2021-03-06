# encoding='utf-8'

'''
/**
 * This is the solution of No. 268 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/missing-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 进阶：
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def get_messing_number(self, arr: List[int]) -> int:
        '''
            寻找缺失的数字
        Args:
            arr: 数组
        Returns:
            缺失的数
        '''
        length = len(arr)
        s = set()
        for i in range(length + 1):
            s.add(i)
        for j in range(len(arr)):
            if arr[j] in s:
                s.remove(arr[j])
        if len(s) == 1:
            return s.pop()
        else:
            return -1

    def get_messing_number2(self, arr: List[int]) -> int:
        '''
           寻找缺失的数字
       Args:
           arr: 数组
       Returns:
           缺失的数
       '''
        sum, n = 0, len(arr)
        total_sum = (n + 1) * n // 2
        for i in range(len(arr)):
            sum += arr[i]
        return total_sum - sum

    def get_messing_number3(self, nums: List[int]) -> int:
        '''
           寻找缺失的数字
       Args:
           arr: 数组
       Returns:
           缺失的数
       '''
        result = len(nums)
        for i in range(len(nums)):
            result ^= nums[i]
            result ^= i
        return result


if __name__ == '__main__':
    nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    solution = Solution()
    messing_number = solution.get_messing_number3(nums)
    assert messing_number == 8
