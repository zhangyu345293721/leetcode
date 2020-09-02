# -*- coding:utf-8 -*-
'''/**
 * This is the solution of No. 1281 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个整数数组 A 和一个查询数组 queries。
 *
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * 示例：
 *
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def get_count(A: List[int]) -> int:
    '''
        计算数组的和
    Args:
        A: 输入数组
    Returns:
        求和
    '''
    count = 0
    for num in A:
        if num % 2 == 0:
            count += num
    return count


def sum_even_after_queries(A: List[int], queries: List[List[int]]) -> List[int]:
    '''
        操作数组
    Args:
        A: 数组原始数组
        queries: 按照要求操作数组
    Returns:
        操作后数组
    '''
    new_A = []
    for i in range(len(queries)):
        index = queries[i][1]
        num = queries[i][0]
        A[index] += num
        count = get_count(A)
        new_A.append(count)
    return new_A


if __name__ == '__main__':
    A = [1, 2, 3, 4]
    queries = [[1, 0], [-3, 1], [-4, 0], [2, 3]]
    new_A = sum_even_after_queries(A, queries);
    print(new_A)
