# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 914 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from math import gcd
from typing import List


def has_groups_size_x(deck: List[int]) -> bool:
    '''
        可不可分成相同给数量的组
    Args:
        deck: 数组
    Returns:
        布尔值
    '''
    if not deck or len(deck) < 2:
        return False
    arr = [0] * 10000
    for num in deck:
        arr[num] += 1
    x = 0
    for num in arr:
        if num > 0:
            x = gcd(x, num)
            if x == 1:
                return False
    return x >= 2


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 4, 3, 2, 1]
    res = has_groups_size_x(arr)
    assert res==True
