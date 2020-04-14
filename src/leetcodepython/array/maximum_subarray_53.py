# encoding='utf-8'

'''
数字加上每一位数
author:zhangyu
date:2020.4.09
'''
from typing import List


def max_sub_array(nums: List[int]) -> int:
    '''
        获取到连续子数组最大值
    Args:
        nums:数组
    Returns:
        最大值
    '''
    result, max_value = nums[0], 0
    for i in range(1, len(nums)):
        if result < 0:
            result = nums[i]
        else:
            result += nums[i]
            max_value = max(result, max_value)
    return max_value


if __name__ == '__main__':
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    result = max_sub_array(nums)
    print(result)
