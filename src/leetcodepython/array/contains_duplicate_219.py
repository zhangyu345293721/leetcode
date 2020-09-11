# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 219 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def contains_duplicate2(nums: List[int], k: int) -> bool:
    '''
        判断是否有重复的数
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_dict = {}
    for i in range(len(nums)):
        if nums[i] in number_dict:
            if abs(i - number_dict[nums[i]]) <= k:
                return True
        number_dict[nums[i]] = i
    return False


if __name__ == '__main__':
    nums = [1, 2, 3, 1]
    k = 3
    print(contains_duplicate2(nums, k))
