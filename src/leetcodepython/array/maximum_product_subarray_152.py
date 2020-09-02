# encoding='utf-8'

'''
/**
 * This is the solution of No. 152 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-product-subarray
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def max_product(arrs: List[int]) -> int:
    '''
        数组乘积最大值
    Args:
        arrs: 数组
    Returns:
        乘积
    '''
    if len(arrs) < 1:
        return 0
    max_num,min_num = arrs[0],arrs[0]
    result = arrs[0]
    for i in range(1, len(arrs)):
        temp = max_num
        max_num = max(max(max_num * arrs[i], min_num * arrs[i]), arrs[i])
        min_num = min(min(temp * arrs[i], min_num * arrs[i]), arrs[i])
        if max_num > result:
            result = max_num
    return result


if __name__ == '__main__':
    arr = [2, 3, -2, 4]
    num = max_product(arr)
    print(num)
