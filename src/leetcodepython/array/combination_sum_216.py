# encoding='utf-8'

'''
/**
 * This is the solution of No. 216 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def combination_sum_helper(k: int, target: int, result: List[List[int]], temp: int, num: int) -> None:
    '''
        递归循环帮助类
    Args:
        k: 数字个数
        target: 目标值
        result: 结果链表
        temp: 临时链表
        num: 数值
    Returns:
       链表
    '''
    for i in range(num, 10):
        if i > target:
            break
        temp.append(i)
        if i == target and k == len(temp):
            result.append(list(temp))
        else:
            combination_sum_helper(k, target - i, result, temp, i + 1)
        temp.pop()


def combination_sum(k: int, n: int) -> List[List[int]]:
    '''
        循环计算组合数和
    Args:
        k: 数字个数
        n: 数字和
    Returns:
        None
    '''
    result = []
    temp = []
    combination_sum_helper(k, n, result, temp, 1)
    return result


if __name__ == '__main__':
    k = 3
    n = 9
    result = combination_sum(k, n)
    print(result)
