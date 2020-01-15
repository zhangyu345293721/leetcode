'''
分组最小求和
author:zhangyu
date:2020.1.15
'''
from typing import List


def array_pair_sum(nums: List[int]) -> int:
    '''
        对数组求和，分组最小
    Args:
        nums: 数组
    Returns:
        求和
    '''
    sum = 0
    nums.sort()
    i = 0
    while i < len(nums) - 1:
        min_num = min(nums[i], nums[i + 1])
        sum += min_num
        i += 2
    return sum


if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    sum = array_pair_sum(nums)
    print(sum)
