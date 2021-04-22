# encoding='utf-8'

'''
/**
 * This is the solution of No.84 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def largest_rectangle_histogram(self, heights: List[int]) -> int:
        '''
            计算最大矩形长度
        Args:
            heights: 数组长度
        Returns:
            矩形最大面积
        '''
        if not heights:
            return 0
        stack = []
        max_area, index = 0, 0
        length = len(heights)
        while index <= length:
            if not stack or (index < length and heights[index] >= heights[stack[-1]]):
                stack.append(index)
                index += 1
            else:
                old_index = stack.pop()
                width = index if len(stack) < 1 else index - stack[-1] - 1
                max_area = max(max_area, width * heights[old_index])
        return max_area

    def largest_rectangle_histogram2(self, heights: List[int]) -> int:
        '''
            计算最大矩形长度
        Args:
            heights: 数组长度
        Returns:
            矩形最大面积
        '''
        if not heights or len(heights) < 1:
            return 0
        if len(heights) < 2:
            return heights[0]
        area_max = 0
        for i in range(len(heights)):
            height = heights[i]
            width = 1  # 当前宽度为1
            k = i - 1
            while k >= 0 and heights[k] >= height:
                width += 1
                k -= 1
            k = i + 1
            while k < len(heights) and heights[k] >= height:
                width += 1
                k += 1
            area_max = max(area_max, height * width)
        return area_max


if __name__ == '__main__':
    heights = [2, 1, 5, 6, 2, 3]
    solution = Solution()
    max_area = solution.largest_rectangle_histogram(heights)
    print(max_area)
    assert max_area == 10
