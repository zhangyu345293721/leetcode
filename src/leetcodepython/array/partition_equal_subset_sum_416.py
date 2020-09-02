# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.416 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/partition-equal-subset-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def can_partition(nums: List[int]) -> bool:
    '''
        数组是否可以分为两半
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    total = sum(nums)
    if total % 2 == 1:
        return False
    total = int(total / 2)
    dp = [False] * (total + 1)
    dp[0] = True
    for num in nums:
        i = total
        while i >= num:
            dp[i] = dp[i] or dp[i - num]
            i -= 1
    return dp[total]


if __name__ == '__main__':
    nums = [1, 5, 11, 5]
    result = can_partition(nums)
    print(result)
