package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

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
public class ValidParentheses20 {

    @Test
    public void validParenthesesTest() {
        String s = "{[]}";
        boolean result = isValid(s);
        System.out.println(result);
        Assert.assertEquals(result, false);
    }

    /**
     * 判断是否是有效字符串
     *
     * @param s 字符串
     * @return 布尔值
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ']') {
                if (!stack.isEmpty() && stack.pop() != '[') {
                    return false;
                }
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.pop() != '(') {
                    return false;
                }
            } else {
                if (!stack.isEmpty() && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 判断是否是有效字符串
     *
     * @param s 字符串
     * @return 布尔值
     */
    public boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || ch != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}