from typing import List

'''
author:zhangyu
date:2020.4.16
'''

def subarray_sum_equals_k(nums: List[int], k: int) -> int:
    '''
        找出和相同的数组
    Args:
        nums:数组
        k:固定值
    Returns:
        数组种数
    '''
    total, count, length = 0, 0, len(nums)
    for i in range(length):
        for j in range(i, length):
            total += nums[j]
            if total == k:
                count += 1
                total = 0
                break
    return total

def subarray_sum_equals_k2(nums: List[int], k: int) -> int:
    '''
        找出和相同的数组
    Args:
        nums:数组
        k:固定值
    Returns:
        数组种数
    '''
    count, length = 0, len(nums)
    for i in range(length):
        total = 0
        for j in range(i, length):
            total += nums[j]
            if total == k:
                count += 1
    return count

def subarray_sum_equals_k3(nums: List[int], k: int) -> int:
    '''
        找出和相同的数组
    Args:
        nums:数组
        k:固定值
    Returns:
        数组种数
    '''
    count, total = 0, 0
    map = {}
    map[0] = 1
    for i in range(len(nums)):
        total += nums[i]
        if (total - k) in map:
            count += map[total - k]
        if total not in map:
            map[total] = 1
        else:
            map[total] = map[total] + 1
    return total

if __name__ == '__main__':
    nums = [5, 2, 3, 1]
    result = subarray_sum_equals_k(nums)
    print(result)
