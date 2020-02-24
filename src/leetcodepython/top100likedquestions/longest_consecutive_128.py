# encoding='utf-8'
'''
找出最大的连续子串
author:zhangyu
date:2019.8.28
'''
from typing import List


def get_longest_consecutive(nums: List[int]) -> int:
    '''
        找出最大的连续子串
    Args:
        nums: 数组
    Returns:
        最大子串长度
    '''
    if len(nums) <= 1:
        return len(nums)
    nums.sort()
    max_length = 1
    count = 1
    for i in range(len(nums) - 1):
        if nums[i] + 1 == nums[i + 1]:
            count += 1
        else:
            if nums[i] != nums[i + 1]:
                count = 1
        if max_length < count:
            max_length = count
    return max_length


def get_longest_consecutive2(nums: List[int]) -> int:
    '''
        找出最大的连续子串
    Args:
        nums: 数组
    Returns:
        最大子串长度
    '''
    if len(nums) <= 1:
        return len(nums)
    count = 0
    num_set = set(nums)
    for num in num_set:
        current = 1
        current_num = num
        while (current_num + 1) in nums:
            current += 1
            current_num += 1
        count = max(count, current)
    return count


if __name__ == '__main__':
    nums = [2, 1, 3, 3, 4]
    max_length = get_longest_consecutive2(nums)
    print(max_length)
