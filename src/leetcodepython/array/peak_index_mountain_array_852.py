# encoding='utf-8'

'''
/**
 * This is the solution of No. 852 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def get_peak_index_mountain_array(arr: List[int]) -> int:
    '''
        找出某数组的山顶点
    Args:
        arr: 数组
    Returns:
        山顶元素下标
    '''
    if arr is None or len(arr) < 3:
        return -1
    for i in range(1, len(arr) - 1):
        if arr[i] > arr[i - 1] and arr[i] > arr[i + 1]:
            return i
    return -1


if __name__ == '__main__':
    arr = [1, 2, 1, 0]
    index = get_peak_index_mountain_array(arr)
    print(index)
