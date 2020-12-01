# encoding='utf-8'

'''
/**
 * This is the solution of No.316 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出："abcd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def remove_duplicate_letters(self, s: str) -> str:
        '''
            移除重复字符
        Args:
            s: 字符串
        Returns:
            字典排序表
        '''
        nums_map = self.get_num_map(s)
        in_stack_map = {}
        stack = []
        for ch in s:
            nums_map[ch] -= 1
            if ch in in_stack_map and in_stack_map[ch]:
                continue
            while len(stack) > 0 and ord(ch) < ord(stack[-1]) and nums_map[ch] > 0:
                in_stack_map[stack[-1]] = False
                stack.pop()
            stack.append(ch)
            in_stack_map[ch] = True
        return ''.join(stack)

    def get_num_map(self, s: str):
        '''
            统计字符出现个数
        Args:
            s: 字符串
        Returns:
            map
        '''
        num_map = {}
        for ch in s:
            if ch in num_map:
                num_map[ch] += 1
            else:
                num_map[ch] = 1
        return num_map


if __name__ == '__main__':
    s = 'cdadabcc'
    solution = Solution()
    result = solution.remove_duplicate_letters(s)
    assert result == 'adbc'
