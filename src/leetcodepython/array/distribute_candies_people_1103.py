# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1103 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/distribute-candies-to-people
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 排排坐，分糖果。
 *
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 * 示例 1：
 *
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * 示例 2：
 *
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 *
 * 提示：
 *
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
import numpy as np


class Solution:
    def distribute_candies(self, candies: int, num_people: int) -> str:
        '''
            分发糖果给人
        Args:
            candies: 糖果数
            num_people: 人数
        Returns:
            糖果数组
        '''
        result = [0] * num_people
        i = 0
        while candies > 0:
            result[i % num_people] += min(candies, i + 1)
            candies -= (i + 1)
            i += 1
        return result

    def distribute_candies(self, candies: int, num_people: int) -> str:
        '''
            分发糖果给人(将一维数组转成二维数组形式)
        Args:
            candies: 糖果数
            num_people: 人数
        Returns:
            糖果数组
        '''
        arr = []
        count = 1
        while candies > 0:
            if candies > count:
                arr.append(count)
            else:
                arr.append(candies)
                candies = 0
            candies -= count
            count += 1
        col = int(len(arr) / num_people) + 1
        add_zero = col * num_people - len(arr)
        arr.extend([0] * add_zero)
        x = np.array(arr)
        x = x.reshape((col, num_people))
        total_arr = []
        col = x.shape[1]
        for i in range(col):
            total_arr.append(sum(x[:, i]))
        return total_arr


if __name__ == '__main__':
    candies = 10
    num = 3
    solution = Solution()
    result = solution.distribute_candies(candies, num)
    print(result)
