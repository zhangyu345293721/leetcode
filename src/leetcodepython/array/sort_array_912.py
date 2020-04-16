from typing import List

'''
author:zhangyu
date:2020.4.16
'''
def sort_array(nums: List[int]) -> List[int]:
    '''
        对数组进行排序
    Args:
        nums: 数组
    Returns:
        排序好的数组
    '''
    if len(nums) < 2:
        return nums
    p = nums[len(nums) // 2]
    left = [x for x in nums if x < p]
    middle = [x for x in nums if x == p]
    right = [x for x in nums if x > p]
    return sort_array(left) + middle + sort_array(right)


if __name__ == '__main__':
    nums = [5, 2, 3, 1]
    result = sort_array(nums)
    print(result)
