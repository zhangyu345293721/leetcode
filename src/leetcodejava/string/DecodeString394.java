package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * This is the solution of No. 394 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/decode-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DecodeString394 {
    @Test
    public void decodeStringTest() {
        String s = "3[a]2[bc]";
        String result = decodeString(s);
        System.out.println(result);
        Assert.assertEquals(result, "aaabcbc");
    }

    /**
     * 解析字符串
     *
     * @param s 输入字符
     * @return 解析后字符串
     */
    public String decodeString(String s) {
        if (s.indexOf('[') == -1 || s.indexOf(']') == -1) {
            return s;
        }
        char[] t = s.toCharArray();
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            // 找到"["的位置
            int idx = s.indexOf('[', i);
            if (idx == -1) {
                sb.append(s.substring(i));
                break;
            }
            while (t[i] < '0' || t[i] > '9') {
                sb.append(t[i]);
                i++;
            }
            // 找到数字
            int len = Integer.valueOf(s.substring(i, idx));
            int count = 1;
            i = idx + 1;
            // 找出"]"下标位置
            while (count != 0) {
                if (t[i] == '[') {
                    count++;
                }
                if (t[i] == ']') {
                    count--;
                }
                i++;
            }
            String sub = decodeString(s.substring(idx + 1, i - 1));
            for (int k = 0; k < len; k++) {
                sb.append(sub);
            }
        }
        return sb.toString();
    }

    /**
     * 解析字符串,利用字符串栈和数字栈存储字符和数字
     *
     * @param s 输入字符
     * @return 解析后字符串
     */
    public String decodeString2(String s) {
        if (s.indexOf('[') == -1 || s.indexOf(']') == -1) {
            return s;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder tail = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStack.add(num);
            } else if (ch == '[') {
                strStack.push(tail.toString());
                tail = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    temp.append(tail);
                }
                tail = temp;
            } else {
                tail.append(ch);
            }
        }
        return tail.toString();
    }
}
