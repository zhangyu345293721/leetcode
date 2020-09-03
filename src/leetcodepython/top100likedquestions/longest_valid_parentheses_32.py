'''
/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

'''
from typing import List


def get_longest_valid_parentheses(strs: List[str]) -> int:
    '''
        遍历所有的括号
    Args:
        strs: 字符串
    Returns:
        匹配字符串长度
    '''
    max_len = 0
    for i in range(len(strs)):
        j = i + 2
        while j <= len(strs):
            if is_valid_parentheses(strs[i:j]):
                max_len = max(max_len, j - i)
            j += 2
    return max_len


def is_valid_parentheses(strs: List[str]) -> bool:
    '''
        判断括号是不是匹配
    Args:
        strs: 字符串
    Returns:
        布尔值
    '''
    stack = list()
    for i in range(len(strs)):
        if strs[i] == '(':
            stack.append('(')
        elif len(stack) != 0 and stack[len(stack) - 1] == '(':
            stack.pop()
        else:
            return False
    return len(stack) == 0


if __name__ == '__main__':
    strs = '()()'
    max_len = get_longest_valid_parentheses(strs)
    print(max_len)
