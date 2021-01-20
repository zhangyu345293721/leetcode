# encoding='utf-8'

'''
/**
 * This is the solution of No.57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/happy-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 * <p>
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], new_interval: List[int]) -> List[List[int]]:
        '''
            一个排序好的区间插入一个区间
        Args:
            intervals: 联系区间
            new_interval: 新区间
        Returns:
            合并后区间
        '''
        left = new_interval[0]
        right = new_interval[1]
        place = False
        result = []
        for interval in intervals:
            if interval[0] > right:
                if not place:
                    result.append([left, right])
                    place = True
                result.append(interval)
            elif interval[1] < left:
                result.append(interval)
            else:
                left = min(left, interval[0])
                right = max(right, interval[1])
        if not place:
            result.append([left, right])
        return result


if __name__ == '__main__':
    intervals = [[1, 3], [6, 9]]
    new_interval = [2, 5]
    solution = Solution()
    result = solution.insert(intervals, new_interval)
    print(result)
    assert result[0] == [1, 5]
    assert len(result) == 2
