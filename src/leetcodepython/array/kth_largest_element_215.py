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
import random


class Solution:
    def kth_largest_element_num_1(self, nums: List[int], k: int) -> int:
        '''
            找出第K个大的数
        Args:
            nums: 数组
            k: k个最大数
        Returns:
            第k大那个数
        '''
        new_arr = sorted(nums, reverse=True)
        return new_arr[k - 1]

    def kth_largest_element_num_2(self, nums: List[int], k: int) -> int:
        '''
            找出第K个大的数
        Args:
            nums: 数组
            k: k个最大数
        Returns:
            第k大那个数
        '''
        if nums == None or len(nums) < k:
            return None
        return self.quick_sort(nums, 0, len(nums) - 1, k)

    def quick_sort(self, nums: List[int], l: int, r: int, k: int) -> int:
        '''
            快速排序
        Args:
            nums: 数组
            l: 位置l
            r: 位置r
            k:  第k大的数
        Returns:
            数字
        '''
        index = self.random_partition(nums, l, r)
        if index == k - 1:
            return nums[k - 1]
        elif index > k - 1:
            return self.quick_sort(nums, l, index - 1, k)
        else:
            return self.quick_sort(nums, index + 1, r, k)

    def random_partition(self, nums: List[int], l: int, r: int) -> int:
        '''
            随机生成数组
        Args:
            nums: 数组
            l:位置l
            r:位置r
        Returns:
            位置
        '''
        i = random.randint(l, r)
        self.swap(nums, i, r)
        return self.partition(nums, l, r)

    def swap(self, nums: List[int], l: int, r: int) -> None:
        """
            交换两个数的位置
        Args:
            nums: 数组
            l: 位置l
            r: 位置r
        Returns:
            None
        """
        temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp

    def partition(self, nums: List[int], l: int, r: int) -> int:
        '''
            分组
        Args:
            nums: 数组
            l: 位置l
            r: 位置r
        Returns:
            分组
        '''
        pivot = nums[r]
        right_most = r
        while l <= r:
            while l <= r and nums[l] > pivot:
                l += 1
            while l <= r and nums[r] <= pivot:
                r -= 1
            if l <= r:
                self.swap(nums, l, r)
        self.swap(nums, l, right_most)
        return l

    def kth_largest_element_num_1(self, arr: List[int], k: int) -> int:
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
    solution = Solution()
    num = solution.kth_largest_element_num_2(numbers, 2)
    print(num)
    assert num == 7
