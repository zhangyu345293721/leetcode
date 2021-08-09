package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * This is the solution of No.151 problem in the book <i>Cracking the Coding Interview</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-words-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseWordsString151 {

    @Test
    public void reverseWordsStringTest() {
        String s = "the sky is blue";
        String result = reverseWords(s);
        System.out.println(result);
        Assert.assertEquals(result,"blue is sky the");
    }

    /**
     * 反转单词
     *
     * @param s 字符串
     * @return 反转后单词
     */
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] s1 = s.trim().split(" +");
        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append(s1[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 反转单词
     *
     * @param s 字符串
     * @return 反转后单词
     */
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                j = s.lastIndexOf(' ', i);
                sb.append(s, j + 1, i + 1);
                sb.append(' ');
                i = j;
            }
            --i;
        }
        return sb.toString().trim();
    }

    /**
     * 反转单词
     *
     * @param s 字符串
     * @return 反转后单词
     */
    public String reverseWords3(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
