# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2021/1/14
'''
from typing import List


class Solution:
    def three_sum(self, nums: List[int]):
        '''
            计算3个数的和
        Args:
            nums: 数组
        Returns:
            返回值
        '''
        num_set = set()
        nums.sort()
        length = len(nums)
        for i in range(length):
            j = i + 1
            k = length - 1
            while j < k:
                total = nums[i] + nums[j] + nums[k]
                if total == 0:
                    num_set.add((nums[i], nums[j], nums[k]))
                    j += 1
                elif total > 0:
                    k -= 1
                else:
                    j += 1
        return list(num_set)


if __name__ == '__main__':
    nums = [-1, 0, 1, 2, -1, -4]
    solution = Solution()
    result = solution.three_sum(nums)
    print(result)
    assert result == [(-1, -1, 2), (-1, 0, 1)]
