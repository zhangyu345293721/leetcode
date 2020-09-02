# encoding='utf-8'

'''
/**
 * This is the solution of No. 136 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/single-number
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def single_number(arr: List[int]) -> int:
    '''
        求只出现一次的数字
    Args:
        arr: 数组
    Returns:
        数字
    '''
    set_arr = set()
    for ele in arr:
        if ele in set_arr:
            set_arr.remove(ele)
        else:
            set_arr.add(ele)
    return set_arr.pop()


def single_number2(arr: List[int]) -> int:
    '''
       求只出现一次的数字
   Args:
       arr: 数组
   Returns:
       数字
   '''
    single_number = arr[0]
    for i in range(1, len(arr)):
        single_number = single_number ^ arr[i]
    return single_number


if __name__ == '__main__':
    arr = [2, 3, 3, 2, 4]
    element = single_number(arr)
    print(element)
