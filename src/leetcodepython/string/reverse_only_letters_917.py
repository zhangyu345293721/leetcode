# encoding='utf-8'

'''
/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-only-letters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def reverse_only_letters(self, chs: str) -> str:
        '''
            反转字符串
        Args:
            chs: 字符串数组
        Returns:
            反转后字符串
        '''
        if len(chs) < 2:
            return chs
        arrs = list(chs)
        i = 0
        j = len(chs) - 1
        while i < j:
            if str(arrs[i]).isalpha() and str(arrs[j]).isalpha():
                self.swap(arrs, i, j)
                i += 1
                j -= 1
            elif str(arrs[i]).isalpha():
                j -= 1
            elif str(arrs[j]).isalpha():
                i += 1
            else:
                i += 1
                j -= 1
        return ''.join(arrs)

    def swap(self, chs: List[str], i: int, j: int) -> None:
        '''
            交换数组位置
        Args:
            chs: 数组
            i: 位置i
            j: 位置j
        Returns:
            交换位置后的数组
        '''
        temp = chs[i]
        chs[i] = chs[j]
        chs[j] = temp


if __name__ == '__main__':
    solution = Solution()
    reverse_str = solution.reverse_only_letters('a-b-vf')
    print(reverse_str)
