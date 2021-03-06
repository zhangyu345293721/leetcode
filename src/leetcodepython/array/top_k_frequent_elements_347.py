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
import queue


class Solution:
    def get_num_map(self, nums: List[int]) -> dict:
        '''
            生成频率数组
        Args:
            nums:数组
        Returns:
            返回map
        '''
        num_map = {}
        for num in nums:
            if num in num_map:
                num_map[num] += 1
            else:
                num_map[num] = 1
        return num_map

    def top_k_frequent(self, nums: List[int], k: int) -> List[int]:
        '''
            截取链表长度
        Args:
            nums: 数组
            k: 最大k
        Returns:
            频率最高的k
        '''
        num_map = self.get_num_map(nums)
        dict_sort_list = sorted(num_map.items(), key=lambda x: x[1], reverse=True)
        return [x[0] for x in dict_sort_list[0:k]]

    def top_k_frequent_2(self, nums: List[int], k: int) -> List[int]:
        '''
            截取链表长度
        Args:
            nums: 数组
            k: 最大k
        Returns:
            频率最高的k
        '''
        result = []
        num_map = self.get_num_map(nums)
        q = queue.PriorityQueue()
        for e in num_map.items():
            q.put([e[1], e[0]])
            if q.qsize() > k:
                q.get()

        while not q.empty():
            result.append(q.get()[1])
        return result

    def top_k_frequent_3(self, nums: List[int], k: int) -> List[int]:
        '''
           截取链表长度
       Args:
           nums: 数组
           k: 最大k
       Returns:
           频率最高的k
       '''
        num_map = self.get_num_map(nums)
        # 找到最大出现次数
        max_size = 0
        for num in num_map:
            if num_map[k] > max_size:
                max_size = num_map[num]
        # 找结果集
        result = []
        while k > 0:
            for num in num_map:
                if num_map[num] == max_size:
                    result.append(num)
                    k -= 1
            max_size -= 1
        return result


if __name__ == '__main__':
    nums = [1, 1, 1, 2, 2, 3]
    solution = Solution()
    result = solution.top_k_frequent_3(nums, 2)
    assert len(result) == 2
    assert result == [1, 2]
