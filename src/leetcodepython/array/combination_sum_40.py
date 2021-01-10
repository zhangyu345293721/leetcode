# encoding='utf-8'

'''
/**
 * This is the solution of No. 40 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List, Tuple


def combination_sum_helper(candidates: List[int], target: int, result: List[List[int]], temp: List[int],
                           index: int) -> None:
    '''
        求和帮助类
    Args:
        candidates: 候选数组
        target: 目标值
        result: 结果数组
        temp: 临时数组
        index: 下标
    Returns:
        None
    '''
    for i in range(index, len(candidates)):
        if candidates[i] > target:
            return
        if i > index and candidates[i] == candidates[i - 1]:
            continue
        temp.append(candidates[i])
        if candidates[i] == target:
            result.append(list(temp))
        else:
            combination_sum_helper(candidates, target - candidates[i], result, temp, i + 1)
        temp.pop()


def combination_sum(candidates: List[int], target: int) -> List[List[int]]:
    '''
        联合计算的值
    Args:
        candidates: 候选数据
        target: 目标值
    Returns:
        返回结果链表
    '''
    result = []
    temp = []
    combination_sum_helper(candidates, target, result, temp, 0)
    return result


if __name__ == '__main__':
    candidates = [2, 4, 5, 8]
    target = 7
    result = combination_sum(candidates, target)
    print(result)
    assert result == [[2, 5]]
