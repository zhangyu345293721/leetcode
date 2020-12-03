# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1029 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/two-city-scheduling
 *
 * The description of problem is as follow:
 * =========================================================================================================
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def two_city_scheduling(self, arr: List[List[int]]) -> int:
        '''
            找出一半的人去的城市最小总距离
        Args:
            arr: 二维数组
        Returns:
            距离
        '''
        arr.sort(key=lambda s: s[0] - s[1])
        size = len(arr)
        a_sum = sum([arr[i][0] for i in range(size // 2)])
        b_sum = sum(arr[i][1] for i in range(size // 2, size))
        return a_sum + b_sum


if __name__ == '__main__':
    arr = [[10, 20], [30, 200], [400, 50], [30, 20]]
    solution = Solution()
    total_sum = solution.two_city_scheduling(arr)
    print(total_sum)
