from typing import List

"""
/**
 * This is the solution of No. 1089 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/duplicate-zeros
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
"""


class Solution:

    def duplicate_zeros(self, arr: List[int]) -> None:
        '''
            重复数组中的0
        Args:
            nums: 数组
        '''
        nums = []
        for i in range(len(arr)):
            if arr[i] == 0:
                nums.append(0)
            nums.append(arr[i])
            if len(arr) == len(nums):
                arr = nums
                return

    def duplicate_zeros2(self, arr: List[int]) -> None:
        '''
            重复数组中的0
        Args:
            nums: 数组
        '''
        i = 0
        while i < len(arr):
            if arr[i] == 0:
                arr.insert(i, 0)
                arr.pop()
                i += 2
            else:
                i += 1


if __name__ == '__main__':
    nums = [1, 0, 2, 3, 0, 4, 5, 0]
    solution = Solution()
    result = solution.duplicate_zeros2(nums)
    print(result)
    assert result == None
