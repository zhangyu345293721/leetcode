import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: GenerateParentheses1
 * @Description: TOTO
 * @date 2018/12/15 14:31
 **/


public class GenerateParentheses1 {
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
