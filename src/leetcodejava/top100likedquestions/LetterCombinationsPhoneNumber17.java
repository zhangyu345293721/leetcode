package leetcodejava.top100likedquestions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.17 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LetterCombinationsPhoneNumber17 {
    @Test
    public void testLetterCombinationsPhoneNumber() {
        String digits = "23";
        List<String> list = letterCombinationsPhoneNumber(digits);
        System.out.println(list);
    }

    /**
     * 获取链表长度的list，然后再进行买个遍历
     *
     * @param digits 字符串数组
     * @return list
     */
    private List<String> letterCombinationsPhoneNumber(String digits) {
        List<String> list = new ArrayList<>();
        for (char ch : digits.toCharArray()) {
            String newString = getString(ch);
            list.add(newString);
        }
        return list;
    }

    /**
     * 获取字符串
     *
     * @param c 字符c
     * @return 字符串
     */
    private String getString(char c) {
        if (c >= '2' || c <= '9') {
            switch (c) {
                case '2':
                    return "abc";
                case '3':
                    return "def";
                case '4':
                    return "ghi";
                case '5':
                    return "jkl";
                case '6':
                    return "mno";
                case '7':
                    return "pqrs";
                case '8':
                    return "tuv";
                case '9':
                    return "wxyz";
                default:
                    break;
            }
        }
        return "";
    }
}
