# encoding='utf-8'
'''
/**
 * This is the solution of No.56 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-intervals
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        '''
            合并区间
        Args:
            intervals: 区间对象
        Returns:
            区间集合
        '''
        if not intervals or len(intervals) < 1:
            return intervals
        intervals.sort(key=lambda x: x[0])
        merged = []
        cur = intervals[0]
        for i in range(1, len(intervals)):
            if cur[1] >= intervals[i][0]:
                cur[1] = max(cur[1], intervals[i][1])
            else:
                merged.append(cur)
                cur = intervals[i]
        merged.append(cur)
        return merged


if __name__ == '__main__':
    nums = [[1, 2], [1, 4]]
    solution = Solution()
    merged = solution.merge(nums)
    print(merged)
    assert merged[0][0] == 1
    assert merged[0][1] == 4
