package leetcodejava.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照要求生成括号
 *
 * @author zhangyu
 **/


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
            return null;
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
        if (left < n)
            bracketTrace(list, s + "(", left + 1, right, n);
        if (right < left)
            bracketTrace(list, s + ")", left, right + 1, n);
    }
}
