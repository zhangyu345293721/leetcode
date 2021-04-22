# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.42 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def trapping_rain_water(self, height: List[int]) -> int:
        '''
            计算能装多少水
        Args:
            height:数组
        Returns:
            装的水
        '''
        if height is None or len(height) < 3:
            return 0
        result, size = 0, len(height)
        for i in range(size - 1):
            max_left = 0
            max_right = 0
            j = i
            while j >= 0:
                max_left = max(max_left, height[j])
                j -= 1
            k = i
            while k < size:
                max_right = max(max_right, height[k])
                k += 1
            result += min(max_left, max_right) - height[i]
        return result

    def trapping_rain_water2(self, height: List[int]) -> int:
        '''
            计算能装多少水
        Args:
            height:数组
        Returns:
            装的水
        '''
        if not height or len(height) < 3:
            return 0
        left_max, right_max = 0, 0
        left, right = 0, len(height) - 1
        result = 0
        while left < right:
            if height[left] < height[right]:
                left_max = max(left_max, height[left])
                result += (left_max - height[left])
                left += 1
            else:
                right_max = max(right_max, height[right])
                result += (right_max - height[right])
                right -= 1
        return result


if __name__ == '__main__':
    arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    solution = Solution()
    result = solution.trapping_rain_water2(arr)
    assert result == 6
