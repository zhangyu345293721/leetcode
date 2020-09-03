# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1207 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-number-of-occurrences
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def unique_number_occurrences(arr: List[int]) -> bool:
    '''
        找出数组出现独特次数
    Args:
        arr: 输入数组
    Returns:
        布尔值
    '''
    num_dict = {}
    for num in arr:
        if num in num_dict:
            num_dict[num] += 1
        else:
            num_dict[num] = 0
    num_set = set()
    for time in num_dict.values():
        num_set.add(time)
    return len(num_set) == len(num_dict)


if __name__ == '__main__':
    arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    result = unique_number_occurrences(arr)
    print(result)
