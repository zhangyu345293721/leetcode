# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1002 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/di-string-match
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''

from typing import List


class Solution:
    def di_string_match(self, s: str) -> List[int]:
        '''
            对数字按照要求进行排序
        Args:
            s:字符串
        Returns:
            字符串数组
        '''
        start = 0
        end = len(s)
        arr = [0] * (end + 1)
        for i in range(len(s)):
            if s[i] == 'D':
                arr[i] = end
                end -= 1
            else:
                arr[i] = start
                start += 1
        arr[len(s)] = start
        return arr


if __name__ == '__main__':
    string = 'DDI'
    solution = Solution()
    list_arr = solution.di_string_match(string)
    print(list_arr)
    assert list_arr == [3, 2, 0, 1]
