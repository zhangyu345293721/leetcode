# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.496 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/next-greater-element-i
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 *     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def next_greater_element(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
            获取比较大的数组
        Args:
            nums1: 数组1
            nums2: 数组2
        Returns:
            结果数组
        '''
        greater_dict = {}
        stack = []
        result = []
        for num in nums2:
            while len(stack) > 0 and stack[-1] < num:
                greater_dict[stack.pop(-1)] = num
            stack.append(num)
        while len(stack) > 0:
            greater_dict[stack.pop(-1)] = -1
        for num in nums1:
            result.append(greater_dict[num])
        return result

    def next_greater_element_2(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
            获取比较大的数组
        Args:
            nums1: 数组1
            nums2: 数组2
        Returns:
            新数组
        '''
        res = []
        stack = []
        for num in nums2:
            stack.append(num)
        for num in nums1:
            max_num = -1
            temp = []
            is_found = False
            while len(stack) > 0 and not is_found:
                top = stack.pop()
                if top > num:
                    max_num = top
                elif top == num:
                    is_found = True
                temp.append(top)
            res.append(max_num)
            while len(temp) > 0:
                stack.append(temp.pop())
        return res


if __name__ == '__main__':
    nums1 = [2, 4]
    nums2 = [1, 2, 3, 4]
    solution = Solution()
    result = solution.next_greater_element_2(nums1, nums2)
    print(result)
    assert len(result) == 2
