package leetcodejava.string;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This is the solution of No.890 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *  
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * 分割得到的每个字符串都必须是平衡字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SplitString1221 {

    @Test
    public void splitStringTestDemo() {
        String s = "RLRRRLLRLL";
        int count = balancedStringSplit(s);
        System.out.println("count = " + count);
    }

    /**
     * 找出可以分成几个L和R的字符串
     *
     * @param s 输入字符串
     * @return 返回数量
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (ch == 'L') {
                    if (stack.peek() == 'R') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                if (ch == 'R') {
                    if (stack.peek() == 'L') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                if (stack.isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }
}
