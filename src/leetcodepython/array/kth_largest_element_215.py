# encoding='utf-8'

'''
/**
 * This is the solution of No.215 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 通过次数120,951提交次数193,510
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''

from queue import PriorityQueue as PQ
from typing import List


def find_k_max_number(arr: List[int], k: int) -> int:
    '''
        找出第K个大的数
    Args:
        arr: 数组
        k: k个最大数
    Returns:
        第k大那个数
    '''
    new_arr = sorted(arr, reverse=True)
    return new_arr[k - 1]


def kth_largest_element_num(arr: List[int], k: int) -> int:
    '''
        找出第K个大的数
    Args:
        arr: 数组
        k: k个最大数
    Returns:
        第k大那个数
    '''
    pq = PQ()
    for ele in arr:
        pq.put(ele)
        if pq.qsize() > k:
            pq.get()
    return pq.get()


if __name__ == '__main__':
    numbers = [1, -3, 2, 9, 4, 7, 5]
    num = find_k_max_number(numbers, 2)
    print(num)
