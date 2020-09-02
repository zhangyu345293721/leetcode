# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 728 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/self-dividing-numbers
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def judge_dividing_number(i: int) -> bool:
    '''
        判断是不是自除数
    Args:
        i: 输入数
    Returns:
        布尔值
    '''
    flag = True
    temp = i
    while i > 0:
        num = i % 10
        i = i // 10
        if num == 0 or temp % num != 0:
            flag = False
    return flag


def self_dividing_numbers(left: int, right: int) -> List[int]:
    '''
        找出自除数
    Args:
        left: 左边
        right: 右边
    Returns:
        list链表
    '''
    dividing_num_list = []
    for i in range(left, right + 1):
        flag = judge_dividing_number(i)
        if flag:
            dividing_num_list.append(i)
    return dividing_num_list


if __name__ == '__main__':
    left = 1
    right = 20
    print(self_dividing_numbers(left, right))
