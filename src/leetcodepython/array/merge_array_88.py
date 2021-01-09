'''
/**
 * This is the solution of No. 88 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def merge1(self, A: List[int], m: int, B: List[int], n: int) -> None:
        '''
            按照要求合并链表
        Args:
            A: 链表A
            m: 位置m
            B: 链表B
            n: 位置n
        '''
        A = A[:m]
        A.extend(B)

    def merge2(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        '''
            按照要求合并链表
        Args:
            nums1: 链表A
            m: 位置m
            nums2: 链表B
            n: 位置n
        '''
        i, j, k = m - 1, n - 1, n + m - 1
        while i >= 0 and j >= 0:
            if nums1[i] >= nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1
        while j >= 0:
            nums1[k] = nums2[j]
            j -= 1
            k -= 1


if __name__ == '__main__':
    A = [1, 2, 0, 0]
    B = [3, 6]
    solution = Solution()
    solution.merge1(A, 2, B, 2)
    assert len(A) == 4
