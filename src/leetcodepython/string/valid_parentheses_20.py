# encoding='utf-8'

'''
/**
 * This is the solution of No. 20 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/valid-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def is_valid(self, s: str) -> bool:
        """
            判断括号是否匹配
        Args:
            s:括号字符串
        Returns:
            布尔值
        """
        if len(s) % 2 == 1:
            return False
        stack = []
        for ch in s:
            if ch == '[' or ch == '(' or ch == '{':
                stack.append(ch)
            elif ch == ']':
                if not stack or stack.pop() != '[':
                    return False
            elif ch == ')':
                if not stack or stack.pop() != '(':
                    return False
            else:
                if not stack or stack.pop() != '{':
                    return False
        return not stack

    def is_valid2(self, s: str) -> bool:
        """
            判断括号是否匹配
        Args:
            s:括号字符串
        Returns:
            布尔值
        """
        stack = []
        for ch in s:
            if ch == '[':
                stack.append(']')
            elif ch == '(':
                stack.append(')')
            elif ch == '{':
                stack.append('}')
            elif not stack or ch != stack.pop():
                return False
        return not stack


if __name__ == '__main__':
    a = '()'
    solution = Solution()
    num = solution.is_valid2(a)
    print(num)
    assert num == True
