# encoding='utf-8'
'''
/**
 * This is the solution of No. 45 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jump-game-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def jump(nums: List[int]) -> int:
    '''
        数组
    Args:
       nums: 数组
    Returns:
        最小步数
    '''
    length = len(nums)
    end = 0  # 这一跳截止点
    max_pos = 0  # 下一跳最远点
    res = 0
    for i in range(length - 1):
        max_pos = max(max_pos, i + nums[i])
        if i == end:
            end = max_pos
            res += 1
    return res

if __name__ == '__main__':
    nums = [2, 3, 1, 1, 4]
    jump = jump(nums)
    print(jump)