# encoding='utf-8'

'''
/**
 * This is the solution of No. 128 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-consecutive-sequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def get_longest_consecutive(arr: List[int]) -> List[int]:
    '''
        找出最大连续子串
    Args:
        arr: 数组

    Returns:
        连续子串长度

    '''
    if len(arr) <= 1:
        return len(arr)
    # 对数组进行排序
    arr.sort()
    max_length, count = 1, 1
    for i in range(len(arr) - 1):
        if arr[i] + 1 == arr[i + 1]:
            count += 1
        else:
            if arr[i] != arr[i + 1]:
                count = 1
        if max_length < count:
            max_length = count
    return max_length


if __name__ == '__main__':
    arr = [2, 1, 3, 3, 4]
    max_length = get_longest_consecutive(arr)
    print(max_length)
