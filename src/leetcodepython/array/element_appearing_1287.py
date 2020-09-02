# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1287 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 * 示例：
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * 提示：
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def find_special_integer(arr: List[int]) -> int:
    '''
        找出数组中出现次数大于25%
    Args:
        arr: 数组
    Returns:
        数
    '''
    arr_dict = {}
    for num in arr:
        if num in arr_dict:
            arr_dict[num] += 1
        else:
            arr_dict[num] = 1
    for key in arr_dict:
        if arr_dict[key] * 4 > len(arr):
            return key
    return -1


if __name__ == '__main__':
    arr = [1, 2, 2, 6, 6, 6, 6, 7, 10]
    num = find_special_integer(arr)
    print(num)
