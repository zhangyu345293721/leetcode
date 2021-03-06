# encoding='utf-8'

'''
/**
 * This is the solution of No. 55 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jump-game/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def jump_game_1(arr: List[int]) -> bool:
        '''
            看是否能跳过数组
        Args:
            arr: 输入数组
        Returns:
            布尔值
        '''
        max = 0
        length = len(arr)
        for index in range(1, length):
            if arr[index - 1] == 0 and index > arr[max] + max:
                return False
            if arr[max] - (index - max) < arr[index]:
                max = index
        return True

    def jump_game_2(self, nums: List[int]) -> bool:
        '''
             跳远数组
        Args:
            nums: 数组
        Returns:
            是否能调到最后，布尔值
        '''''
        if len(nums) < 2:
            return True
        if nums == None or arr[0] == 0:
            return True
        for i in range(len(nums)):
            if nums[i] == 0:
                flag = self.jump_flag(nums, i)
                if flag:
                    continue
                else:
                    return flag
        return True
    def jump_flag(self, nums: List[int], i: int) -> bool:
        '''
            能不能跳过0点
        Args:
            nums: 数组
            i: 位置i
        Returns:
            布尔值
        '''
        j = i
        while j > 0:
            if nums[j] > i - j:
                return True
            j -= 1
        return False

if __name__ == '__main__':
    arr = [2, 3, 1, 1, 4]
    solution = Solution()
    flag = solution.jump_game_2(arr)
    print(flag)
    assert flag == True
