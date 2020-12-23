# encoding='utf-8'

'''
/**
 * This is the solution of No. 15 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/3sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def three_sum(self, nums: List[int]) -> List[List[int]]:
        '''
            三个数之和
        Args:
            nums: 数组
        Returns: 链表
        '''
        s = set()
        nums.sort()
        for i in range(len(nums)):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                total = nums[i] + nums[j] + nums[k]
                if total == 0:
                    s.add((nums[i], nums[j], nums[k]))
                    j += 1
                elif total < 0:
                    j += 1
                else:
                    k -= 1
        return list(s)


if __name__ == '__main__':
    nums = [-1, 0, 1, 2, -1, -4, 0, 0]
    solution = Solution()
    result =solution.three_sum(nums)
    print(result)
    assert result==[(-1, -1, 2), (-1, 0, 1), (0, 0, 0)]
