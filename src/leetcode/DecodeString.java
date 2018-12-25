package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: DecodeString
 * @Description: TOTO
 * @date 2018/12/11 11:36
 **/

// 这种方式没有做出来，如果是循环嵌套的话就有问题
public class DecodeString {
    @Test
    public void fun() {
        String s = "2[abc]3[cd]ef";
        String newString = decodeString(s);
        System.out.println(newString);
    }

    private String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder ssb=new StringBuilder();
        char chs[] = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int figure = 0;
            String ss = "";
            // 如果当前字符串不为']',就一直进栈
            if (chs[i] != ']') {
                stack.push(chs[i]);
            } else {
                // 如果栈顶元素不是‘[’，就出栈
                StringBuilder sub = new StringBuilder();
                while (stack.peek() != '[') {
                    sub.append(stack.pop());
                }
                stack.pop();
                sub = sub.reverse();
                figure = Integer.parseInt(String.valueOf(stack.pop()));
                for (int j = 0; j < figure; j++) {
                    ss += sub.toString();
                    //sb.append(sub);
                }

            }
            sb.append(ss);
        }
        while (!stack.isEmpty()) {
            ssb.append(stack.pop());
        }
        sb.append(ssb.reverse());
        return sb.toString();
    }
}
