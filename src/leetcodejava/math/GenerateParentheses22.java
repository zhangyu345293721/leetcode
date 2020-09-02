package leetcodejava.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.22 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/generate-parentheses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class GenerateParentheses22 {
    @Test
    public void testGenerateParentheses() {
        int n = 3;
        List<String> list = generateParentheses(n);
        System.out.println(list);
    }

    /**
     * 生成括号
     *
     * @param n 输入字符
     * @return
     */
    private List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) {
            return list;
        }
        bracketTrace(list, "", 0, 0, n);
        return list;
    }

    /**
     * 括号位置追踪
     *
     * @param list  链表
     * @param s     字符串
     * @param left  左边
     * @param right 右边
     * @param n     下标
     */
    private void bracketTrace(List<String> list, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (left < n) {
            bracketTrace(list, s + "(", left + 1, right, n);
        }
        if (right < left) {
            bracketTrace(list, s + ")", left, right + 1, n);
        }
    }
}
