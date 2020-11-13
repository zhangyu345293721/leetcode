# encoding='utf-8'

'''
合并数组
author:zhangyu
date:2020.1.9

题目:
     两个有序数组进行合并为一个数组，其中保证数组中没有重复元素
     如: nums1=[1,2,3,4]
         nums2=[4,5,6,7,8]
     合并之后为：result=[1,2,3,,4,5,6,7,8]
'''
from typing import List


class Solution:
    def merge(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
            合并两个数组
        Args:
            nums1:数组1
            nums2:数组2
        Returns:
            合并后数组
        '''
        if not nums1:
            return nums2
        if not nums2:
            return nums1
        i, j, result = 0, 0, []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                result.append(nums1[i])
                i += 1
            elif nums1[i] == nums2[j]:
                result.append(nums1[i])
                i += 1
                j += 1
            else:
                result.append(nums2[j])
                j += 1
        if i == len(nums1):
            result.extend(nums2[j:len(nums2)])
        if j == len(nums2):
            result.extend(nums1[i:len(nums1)])
        return result


if __name__ == '__main__':
    nums1 = [1, 2, 3, 4]
    nums2 = [4, 5, 6, 7, 8]
    solution = Solution()
    res = solution.merge(nums1, nums2)
    print(res)
