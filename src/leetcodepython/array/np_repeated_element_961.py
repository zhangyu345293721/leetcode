# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.961 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def repeated_n_times(A: List[int]) -> int:
    '''
        一个数组出现n次
    Args:
        nums: 数组
    Returns:
        布尔值
    '''
    number_dict = {}
    for num in A:
        if num in number_dict:
            number_dict[num] += 1
        else:
            number_dict[num] = 1
    for item in number_dict.items():
        if item[1] == len(A) / 2:
            return item[0]
    return -1


if __name__ == '__main__':
    arr = [1, 2, 3, 3]
    num = repeated_n_times(arr)
    print(num)
