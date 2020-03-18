package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 0106 problem in the book <i>Cracking the Coding Interview</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/compress-string-lcci/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 * <p>
 * Example 1:
 * Input: "aabcccccaaa"
 * Output: "a2b1c5a3"
 * <p>
 * Example 2:
 * Input: "abbccd"
 * Output: "abbccd"
 * Explanation:
 * The compressed string is "a1b2c2d1", which is longer than the original string.
 *  
 * Note:
 * - 0 <= S.length <= 50000
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CompressString {

    @Test
    public void testCompressString() {
        String str = "addddccc";
        String result = compressString2(str);
        System.out.println(result);
    }

    /**
     * 压缩字符串
     *
     * @param S 字符串
     * @return 压缩后字符串
     */
    public String compressString(String S) {
        if (S == null || S.trim().equals("")) {
            return S;
        }
        StringBuffer sb = new StringBuffer();
        List<String> list = splitString(S);
        for (String s : list) {
            sb.append(s.charAt(0));
            sb.append(s.length());
        }
        return sb.toString().length() >= S.length() ? S : sb.toString();
    }

    /**
     * 将相同的字符串切割成字符串链表
     *
     * @param s 字符串
     * @return 字符串链表
     */
    private List<String> splitString(String s) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                list.add(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        list.add(s.substring(start));
        return list;
    }


    /**
     * 压缩字符串
     *
     * @param S 字符串
     * @return 压缩后字符串
     */
    public String compressString2(String S) {
        if (S == null || S.length()<2) {
            return S;
        }
        StringBuffer sb = new StringBuffer();
        int length = 1;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                length++;
            } else {
                sb.append(S.charAt(i)).append(length);
                length = 1;
            }
        }
        sb.append(S.charAt(S.length() - 1)).append(length);
        return sb.toString().length() >= S.length() ? S : sb.toString();
    }
}
