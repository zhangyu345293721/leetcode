# encoding='utf-8'
'''
/**
 * This is the solution of No. 169 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/majority-element/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * ==========================================================================================================
 * @author  zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def majority_element(nums: List[int]) -> int:
    '''
        大多数元素
    Args:
        nums: 数组
    Returns:
        元素
    '''
    num_dic = {}
    for num in nums:
        if num in num_dic:
            num_dic[num] += 1
        else:
            num_dic[num] = 1
    for key in num_dic.keys():
        if num_dic[key] >= len(nums) / 2:
            return key
    return -1


def majority_element2(nums: List[int]) -> int:
    '''
        大多数元素
    Args:
        nums: 数组
    Returns:
        元素
    '''
    majority, count = 0, 0
    for num in nums:
        if count == 0:
            majority = num
            count += 1
        elif majority == num:
            count += 1
        else:
            count -= 1
    return majority


if __name__ == '__main__':
    nums = [1, 2, 2, 2, 3]
    num = majority_element(nums)
    print(num)
