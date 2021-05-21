# encoding='utf-8'

'''
/**
 * This is the solution of No.344 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def reverse_str(self, s: List[str]) -> None:
        '''
            反转字符串
        Args:
            s: 字符数组s
        Returns:
            None
        '''
        if not s:
            return
        i, j = 0, len(s) - 1
        while i <= j:
            self.swap(s, i, j)
            i += 1
            j -= 1

        def reverse_str2(self, s: List[str]) -> None:
            '''
                反转字符串
            Args:
                s: 字符数组s
            Returns:
                None
            '''
            if not s:
                return
            self.reverse_all(s, 0, len(s) - 1)

    def reverse_all(self, s: List[str], left: int, right: int) -> None:
        '''
            反转字符串
        Args:
            s: 字符数组
            left: left位置
            right: right位置
        Returns:
            None
        '''
        if left >= right:
            return
        self.reverse_all(s, left + 1, right - 1)
        self.swap(s, left, right)

    def swap(self, s: List[str], i: int, j: int) -> None:
        '''
            交换两个元素的位置
        Args:
            s: 字符数组s
            i: 位置i
            j: 位置j
        Returns:
            None
        '''
        temp = s[i]
        s[i] = s[j]
        s[j] = temp


if __name__ == '__main__':
    a = ['a', 'b', 'c', 'd', 'e', 'f']
    solution = Solution()
    solution.reverse_str(a)
    print(a)
