# encoding='utf-8'

'''
/**
 * This is the solution of No. 283 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/move-zeroes
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:

    def move_zeroes(self, nums: List[int]) -> None:
        '''
            数字将0移到后面，保存前面相对顺序不变
        Args:
            nums: 数组
        Returns:
            None
        '''
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index] = nums[i]
                index += 1
        while index < len(nums):
            nums[index] = 0
            index += 1


if __name__ == '__main__':
    nums = [0, 0, 1]
    solution = Solution()
    solution.move_zeroes(nums)
    print(nums)
    assert nums == [1, 0, 0]
