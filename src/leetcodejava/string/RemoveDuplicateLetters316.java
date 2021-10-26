package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.1081 problem in the LeetCode,
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
public class RemoveDuplicateLetters316 {

    @Test
    public void removeDuplicateLettersTest() {
        String s = "ecbacba";
        String result = removeDuplicateLetters2(s);
        System.out.println(result);
        Assert.assertEquals(result, "eacb");
    }

    /**
     * 移除重复的字符
     *
     * @param s 字符串
     * @return 非重复字符串
     */
    public String removeDuplicateLetters(String s) {
        final int L = s.length();
        if (L <= 1) {
            return s;
        }
        // 统计每个字符最后出现的位置
        Map<Character, Integer> lastOccur = new HashMap<>(26);
        for (int i = 0; i < L; ++i) {
            lastOccur.put(s.charAt(i), i);
        }
        // 用栈维护最终返回的字符串
        Set<Character> seen = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>(); // peek() == peekFirst()
        for (int i = 0; i < L; ++i) {
            char c = s.charAt(i);
            if (seen.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peekLast() && i < lastOccur.get(stack.peekLast())) {
                seen.remove(stack.pollLast());
            }
            stack.addLast(c);
            seen.add(c);
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollFirst());
        }
        return ans.toString();
    }

    /**
     * 移除重复的字符
     *
     * @param s 字符串
     * @return 非重复字符串
     */
    public String removeDuplicateLetters2(String s) {
        StringBuffer result = new StringBuffer();
        // 记录字符出现次数map
        Map<Character, Integer> countNumMap = new HashMap<>();
        // 记录字符是否在栈中map
        Map<Character, Boolean> inStackMap = new HashMap<>();
        // 定义一个栈
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            countNumMap.put(ch, countNumMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            countNumMap.put(ch, countNumMap.get(ch) - 1);
            if (inStackMap.get(ch) != null && inStackMap.get(ch)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && countNumMap.get(stack.peek()) > 0) {
                // 元素删除不在栈中
                inStackMap.put(stack.peek(), false);
                stack.pop();
            }
            stack.push(ch);
            inStackMap.put(ch, true);
        }
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }
        return result.toString();
    }
}
