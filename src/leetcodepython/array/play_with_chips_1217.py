# encoding='utf-8'

'''
/**
 * This is the solution of No. 1217 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/play-with-chips
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 *
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 *
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 *
 * 示例 1：
 *
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * 示例 2：
 *
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def min_cost_to_move_chips(self, chips: List[int]) -> int:
        '''
            摆筹码代价最小
        Args:
            chips: 数组
        Returns:
            摆筹码
        '''
        step = 0
        for num in chips:
            if num % 2 == 1:
                step += 1
        return min(step, len(chips) - step)

    def min_cost_to_move_chips2(self, chips: List[int]) -> int:
        '''
            摆筹码代价最小
        Args:
            chips: 数组
        Returns:
            摆筹码
        '''
        step1, step2 = 0, 0
        for num in chips:
            if num % 2 == 1:
                step1 += 1
            else:
                step2 += 1
        return min(step1, step2)


if __name__ == '__main__':
    arr = [2, 2, 2, 3, 3]
    solution = Solution()
    res = solution.min_cost_to_move_chips2(arr)
    print(res)
    assert res == 2
