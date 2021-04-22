# encoding='utf-8'

'''
/**
 * This is the solution of No.349 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/intersection-of-two-arrays
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def intersection(self, nums1: List[int], nums2: List[int]) -> int:
        '''
            求出两个数组的交集
        Args:
            nums1: 数组1
            nums2: 数组2
        Returns:
            数组的交集
        '''
        res = []
        nums1.sort()
        nums2.sort()
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                res.append(nums1[i])
                i += 1
                j += 1
        return res

    def intersection2(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
            两个数组求交集
        Args:
            nums1: 数组1
            nums2: 数组2
        Returns:
            数组交集
        '''
        s, res = set(), []
        for ele in nums1:
            s.add(ele)
        for ele in nums2:
            if ele in s:
                res.append(ele)
                s.remove(ele)
        return res


if __name__ == '__main__':
    nums1 = [1, 2, 2, 3]
    nums2 = [2, 2]
    solution = Solution()
    res = solution.intersection2(nums1, nums2)
    print(res)
    assert res == [2]
