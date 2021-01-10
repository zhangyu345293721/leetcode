# encoding='utf-8'

'''
/**
 * This is the solution of No.300 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List
import numpy as np


class Solution:

    def longest_increasing_subsequence(self, nums: List[int]):
        dp = np.zeros(len(nums))
        length = 0
        for num in nums:
            i = self.binary_search(nums, 0, length, num)
            if i < 0:
                i = -(i + 1)
            dp[i] = num
            if i + 1 > length:
                length = i + 1
        return length

    def binary_search(self, arr: List[int], l: int, r: int, x: int):
        '''
            二分查找
        Args:
            arr: 输入数组
            l: 开始下标
            r: 结束下标
            x: 要查找的数
        Returns:
            要查找数的下标
        '''
        if r >= l:
            mid = int(l + (r - l) / 2)  # 防止溢出
            if arr[mid] == x:
                return mid
            elif arr[mid] > x:
                return self.binary_search(arr, l, mid - 1, x)
            else:
                return self.binary_search(arr, mid + 1, r, x)
        else:
            return -1  # 不存在


if __name__ == '__main__':
    arr = [10, 9, 2, 5, 3, 7, 101, 18]
    solution = Solution()
    length = solution.longest_increasing_subsequence(arr)
    print(length)
