# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 217 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/contains-duplicate
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def contains_duplicate(nums: List[int]) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_dict = {}
    for num in nums:
        if num in number_dict:
            number_dict[num] += 1
        else:
            number_dict[num] = 1
    for num in number_dict.values():
        if num > 1:
            return True
    return False


def contains_duplicate2(nums: List[int]) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_set = set()
    for num in nums:
        if num in number_set:
            return True
        else:
            number_set.add(num)
    return False


if __name__ == '__main__':
    arr = [1, 2, 3, 3, 4]
    print(contains_duplicate(arr))
