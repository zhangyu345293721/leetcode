# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.896 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/monotonic-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：[1,3,2]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def is_monotonic(arr: List[int]) -> bool:
    '''
        判断数组是否一致增减
    Args:
        arr:数组
    Returns:
        布尔值
    '''
    if len(arr) < 2:
        return len(arr) < 2
    increase_count = 0
    decrease_count = 0
    for i in range(1, len(arr)):
        if arr[i] - arr[i - 1] >= 0:
            increase_count += 1
        if arr[i] - arr[i - 1] <= 0:
            decrease_count -= 1
    return decrease_count == len(arr) - 1 or increase_count == len(arr) - 1


if __name__ == '__main__':
    arr = [1]
    flag = is_monotonic(arr)
    print(flag)
