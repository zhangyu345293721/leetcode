# encoding='utf-8'

'''
/**
 * This is the solution of No.239 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sliding-window-maximum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def max_sliding_window(self, nums: List[int], k: int) -> List[int]:
        '''
            找出规定范围最大值
        Args:
            nums: 数组
            k: 窗口大小
        Returns:
            数组
        '''
        if nums == None or len(nums) < 1:
            return None
        length = len(nums)
        res = []
        queue = []
        for i in range(length):
            # 维护一个单调递减队列的元素顺序
            while len(queue) > 0 and nums[i] > nums[queue[-1]]:
                queue.pop(-1)
            # 如果队列下标超过范围，去掉它
            if len(queue) > 0 and i - k > 1 + queue[0]:
                queue.pop(0)
            queue.append(i)
            # 如果i超过或者等于窗口大小，放入窗口中
            if len(queue) > 0 and i >= k - 1:
                res.append(nums[queue[0]])
        return res


if __name__ == '__main__':
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    solution = Solution()
    result = solution.max_sliding_window(nums, k)
    print(result)
    assert result == [3, 3, 5, 5, 6, 7]
