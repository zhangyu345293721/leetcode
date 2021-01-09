# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 406 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def reconstruct_queue(self, people: List[List[int]]) -> List[List[int]]:
        '''
            重构队列
        Args:
            people: 人的排序
        Returns:
            重排之后的数组
        '''
        result = []
        # 第一列逆序，如果相等第二列正序
        people.sort(key=lambda x: (-x[0], x[1]))
        for cur in people:
            result.insert(cur[1], cur)
        return result


if __name__ == '__main__':
    people = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
    solution = Solution()
    result = solution.reconstruct_queue(people)
    print(result)
    assert result == [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
