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


def combination_sum(arr, target):
    '''
        数组
    Args:
        arr: 数组
        target: 目标值
    Returns:
        组合链表
    '''
    result = []
    current = []
    arr.sort()
    helper(arr, target, result, current, 0)
    return result


def helper(arr, target, result, current, param):
    '''
        递归获取结果
    Args:
        arr: 数组
        target:目标
        result:结果集
        current:当前结果
        param:下标
    '''
    for i in range(len(arr)):
        if arr[i] > target:
            break
        current.append(arr[i])
        if target - arr[i] == 0:
            result.append(current)
        else:
            helper(arr, target - arr[i], result, i)
        current.remove(len(current) - 1)
