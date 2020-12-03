# -*- coding:utf-8 -*-
'''
获取最大利益
author:zhangyu
date:2020/3/24
'''
from typing import List


class Solution:
    def massage(self, nums: List[int]) -> int:
        '''
            求最大利润
        Args:
            nums:数组
        Returns:
            最大利润
        '''
        if not nums or len(nums) < 1:
            return 0
        length = len(nums)
        dp = [0] * length
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, length):
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
        return dp[length - 1]


if __name__ == '__main__':
    nums = [1, 2, 3, 1]
    solution = Solution()
    max_profit = solution.massage(nums)
    assert max_profit == 4
