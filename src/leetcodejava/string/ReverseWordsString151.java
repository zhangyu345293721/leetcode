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
        String s = "           the    sky is      blue    ";
        String result = reverseWords4(s);
        System.out.println(result);
        Assert.assertEquals(result, "blue is sky the");
    }

    /**
     * 反转单词
     *
     * @param s 字符串
     * @return 反转后单词
     */
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
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
        if (s == null || s.length() < 2) {
            return s;
        }
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
        if (s == null || s.length() < 2) {
            return s;
        }
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /**
     * 反转单词
     *
     * @param s 字符串
     * @return 反转后单词
     */
    public String reverseWords4(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chs = s.toCharArray();
        // 过滤后数组的长度
        int n = trim(chs);
        if (n == 0) {
            return "";
        }
        reverse(chs, 0, n - 1);
        int i = 0, j = 0;
        while (j < n) {
            if (chs[j] == ' ') {
                reverse(chs, i, j - 1);
                i = ++j;
            }
            if (j == n - 1) {
                reverse(chs, i, j);
            }
            j++;
        }
        char[] newChs = new char[n];
        for (int index = 0; index < n; index++) {
            newChs[index] = chs[index];
        }
        return new String(newChs);
    }

    /**
     * 反转字符串
     *
     * @param chs 字符串数组
     * @param i   下标i
     * @param j   下标j
     */
    public void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 去除空字符串和压缩中间出现过的字符串
     *
     * @param chs 字符串数组
     * @return 新数组长度
     */
    public int trim(char[] chs) {
        int i = 0;
        int len = chs.length;
        int k = 0;
        // 去除字符串前面的字符
        while (i < len && chs[i] == ' ') {
            i++;
        }
        while (i < len) {
            if (chs[i] == ' ') {
                // 当为空字符串
                if (i + 1 < len && chs[i + 1] != ' ') {
                    chs[k++] = ' ';
                }
            } else {
                chs[k++] = chs[i];
            }
            i++;
        }
        return k;
    }
}
