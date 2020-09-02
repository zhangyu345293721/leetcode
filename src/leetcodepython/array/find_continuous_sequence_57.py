# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/insert-interval
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def find_continuous_sequence(target: int) -> List[List[int]]:
    '''
        查找连续的序列
    Args:
        target: 目标值
    Returns:
        目标数组
    '''
    end = int(target / 2) + 1
    result = []
    for i in range(1, end):
        for j in range(i + 1, end + 1):
            total = (i + j) * (j - i + 1) / 2
            if total == target:
                result.append([x for x in range(i, j + 1)])
                break
    return result


def find_continuous_sequence2(target: int) -> List[List[int]]:
    '''
        查找连续的序列
    Args:
        target: 目标值
    Returns:
        目标数组
    '''
    result = []
    left,right = 1,2
    while left < right:
        total = (left + right) * (right - left + 1) / 2
        if total < target:
            right += 1
        elif total > target:
            left += 1
        else:
            result.append([x for x in range(left, right + 1)])
            left += 1
            right += 1
    return result


if __name__ == '__main__':
    result = find_continuous_sequence2(50252)
    print(result)
