'''
/**
 * This is the solution of No.448 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def find_disappeared_numbers(self, nums: List[int]) -> int:
        '''
            找出没有出现过的数字
        Args:
            nums: 数组
        Returns:
            没有出现过的数字
        '''
        if len(nums) < 1:
            return []
        num_set = set()
        result = []
        for num in nums:
            num_set.add(num)
        for i in range(1, len(nums) + 1):
            if i not in num_set:
                result.append(i)
        return result

    def find_disappeared_numbers2(self, nums: List[int]) -> int:
        '''
            找出没有出现过的数字
        Args:
            nums: 数组
        Returns:
            没有出现过的数字
        '''
        if len(nums) < 1:
            return []
        res = []
        n = len(nums)
        for num in nums:
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
        for i in range(1, n + 1):
            if nums[i - 1] > 0:
                res.append(i)
        return res


if __name__ == '__main__':
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    solution = Solution()
    result = solution.find_disappeared_numbers2(nums)
    print(result)
    assert result == [5, 6]
