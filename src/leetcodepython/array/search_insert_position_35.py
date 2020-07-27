# encoding='utf-8'

'''
搜索插入位置

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
author:zhangyu
date:2020.7.17
'''
from typing import List

def search_insert(nums: List[int], target: int) -> int:
    '''
       返回元素插入位置
   Args:
       nums: 数组
       target: 目标值
   Returns:
       返回需要插入的位置
   '''
    if not nums:
        return 0
    length = len(nums)
    if nums[length - 1] < target:
        return length
    if nums[0] >= target:
        return 0
    for i in range(0, length - 1):
        if nums[i] < target and nums[i + 1] >= target:
            return i + 1
    return -1


def search_insert2(nums: List[int], target: int) -> int:
    '''
        返回元素插入位置
    Args:
        nums: 数组
        target: 目标值
    Returns:
        返回需要插入的位置
    '''
    if not nums:
        return 0
    if nums[0] >= target:
        return 0
    i, j = 0, len(nums) - 1
    while i < j:
        middle = i + (j - i) // 2
        if nums[middle] > target:
            j = middle - 1
        elif nums[middle] < target:
            if nums[middle + 1] >= target:
                return middle + 1
            else:
                i = middle + 1
        else:
            return middle
    if nums[j] < target:
        return j + 1
    return -1

if __name__ == '__main__':
    nums = [1, 3, 5, 6]
    target = 5
    result = search_insert2(nums, target)
    print(result)