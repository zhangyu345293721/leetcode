package leetcode.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照要求生成括号
 *
 * @author zhangyu
 **/


public class GenerateParentheses {
    @Test
    public void fun() {
        int n = 3;
        List<String> list = generateParentheses(n);
        System.out.println(list);
    }

    private List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) {
            return null;
        }
        bracketTrace(list, "", 0, 0, n);
        return list;
    }

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
