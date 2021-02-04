# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/9/9
'''

# encoding='utf-8'

'''
/**
 * This is the solution of No.39 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def combination_sum(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
            数组
        Args:
            candidates: 数组
            target: 目标值
        Returns:
            组合链表
        '''
        result = []
        current = []
        candidates.sort()
        self.helper(candidates, target, result, current, 0)
        return result

    def combination_sum2(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
            数组
        Args:
            candidates: 数组
            target: 目标值
        Returns:
            组合链表
        '''
        result = []
        current = []
        candidates.sort()
        self.helper(candidates, target, result, current, 0)
        return result

    def helper(self, candidates: List[int], target: int, result: List[List[int]], current: List[int], index: int) -> None:
        '''
            递归获取结果
        Args:
            candidates: 数组
            target:目标值
            result:结果集
            current:当前结果
            index:下标
        '''
        for i in range(index, len(candidates)):
            if candidates[i] > target:
                break
            current.append(candidates[i])
            if target - candidates[i] == 0:
                # 需要复制数组
                result.append(list(current))
            else:
                self.helper(candidates, target - candidates[i], result, current, i)
            current.pop()

    def helper2(self, candidates: List[int], target: int, result: List[List[int]], current: List[int], index: int) -> None:
        '''
            递归获取结果
        Args:
            candidates: 数组
            target:目标值
            result:结果集
            current:当前结果
            index:下标
        '''
        for i in range(index, len(candidates)):
            current.append(candidates[i])
            if target - candidates[i] == 0:
                current.append(candidates[i])
                result.append(list(current))
            elif target > candidates[i]:
                self.helper(candidates, target - candidates[i], result, current, i)
            else:
                break
            current.pop()


if __name__ == '__main__':
    arr = [2, 3, 6, 7]
    target = 7
    solution = Solution()
    result = solution.combination_sum2(arr, target)
    print(result)
    assert result == [[2, 2, 3], [7]]
