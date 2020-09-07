'''
/**
 * This is the solution of No. 347 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/top-k-frequent-elements
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def get_qrequent_map(nums: List[int]) -> dict:
    '''
        生成频率数组
    Args:
        nums:数组
    Returns:
        返回map
    '''
    qrequent = {}
    for num in nums:
        if num in qrequent:
            qrequent[num] += 1
        else:
            qrequent[num] = 1
    return qrequent


def top_k_frequent(nums: List[int], k: int) -> List[int]:
    '''
        截取链表长度
    Args:
        nums: 数组
        k: 最大k
    Returns:
        频率最高的k
    '''
    qrequent_map = get_qrequent_map(nums)
    dict_sort_list = sorted(qrequent_map.items(), key=lambda x: x[1], reverse=True)
    return [x[0] for x in dict_sort_list[0:k]]


if __name__ == '__main__':
    nums = [1, 1, 1, 2, 2, 3]
    result = top_k_frequent(nums, 2)
    print(result)
