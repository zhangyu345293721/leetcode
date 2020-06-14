# encoding='utf-8'

'''
三个数相加
author:zhangyu
date:2020.6.12
'''
from typing import List


def three_sum(nums: List[int]) -> List[List[int]]:
    '''
        三个数之和
    Args:
        nums: 数组
    Returns: 链表
    '''
    s = set()
    nums.sort()
    for i in range(len(nums)):
        j = i + 1
        k = len(nums) - 1
        while j < k:
            total = nums[i] + nums[j] + nums[k]
            if total == 0:
                s.add((nums[i], nums[j], nums[k]))
                j += 1
            elif total < 0:
                j += 1
            else:
                k -= 1
    return list(s)

if __name__ == '__main__':
    nums = [-1, 0, 1, 2, -1, -4, 0, 0]
    result = three_sum(nums)
    print(result)
