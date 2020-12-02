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

# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.20
   description:合并区间
'''


class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end


def merge(intervals: List[Interval]) -> List[Interval]:
    '''
        合并区间
    Args:
        intervals: 区间对象
    Returns:
        区间集合
    '''
    intervals.sort(key=lambda x: x.start)
    merged = []
    for interval in intervals:
        if not merged or merged[-1].end < interval.start:
            merged.append(interval)
        else:
            merged[-1].end = max(merged[-1].end, interval.end)
    return merged


if __name__ == '__main__':
    i1, i2 = Interval(1, 2), Interval(1, 4)
    arr = []
    arr.extend([i1, i2])
    merged = merge(arr)
    assert merged[0].start == 1
    assert merged[0].end == 4
