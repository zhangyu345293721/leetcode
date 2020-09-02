# encoding='utf-8'
'''
/**
 * This is the solution of No.945 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

def min_increment_for_unique(A: List[int]) -> int:
    '''
        最小增加
    Args:
        A:数组
    Returns:
        独一数组
    '''
    A.sort()
    count = 0
    for i in range(1, len(A)):
        if A[i] <= A[i - 1]:
            temp = A[i]
            A[i] = A[i - 1] + 1
            count += abs(temp - A[i])
    return count

if __name__ == '__main__':
    A = [3, 2, 1, 2, 1, 7]
    count = min_increment_for_unique(A)
    print(count)
