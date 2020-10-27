# encoding='utf-8'

'''
/**
 * This is the solution of No. 11 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def max_area(heights: List[int]) -> int:
    '''
        求最大面积
    Args:
        heights:长度数组
    Returns:
        最大面积
    '''
    if len(heights) < 2:
        return 0
    max_area = 0
    for i in range(len(heights) - 1):
        for j in range(i, len(heights)):
            high = min(heights[i], heights[j])
            max_area=max(max_area, high *  abs(i - j))
    return max_area


def max_area2(heights: List[int]) -> int:
    '''
        求最大面积
    Args:
        heights:长度数组
    Returns:
        最大面积
    '''
    if len(heights) < 2:
        return 0
    max_area, i, j = 0, 0, len(heights) - 1
    while i < j:
        area = min(heights[i], heights[j]) * abs(i - j)
        max_area = max(area, max_area)
        if heights[i] < heights[j]:
            i += 1
        else:
            j -= 1
    return max_area


if __name__ == '__main__':
    arr = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    result = max_area2(arr)
    print(result)
