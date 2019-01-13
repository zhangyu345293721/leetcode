package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LetterCombinationsPhoneNumber
 * @Description: TOTO
 * @date 2018/11/26 15:37
 **/


public class LetterCombinationsPhoneNumber3 {
    @Test
    public void fun() {
        String digits = "24";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }

    // 获取链表长度的list，然后再进行买个遍历
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() < 1) {
            return result;
        }
        // 直接返回，如果输入的数字字符串长度小于1
        String[] newArrs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(newArrs, result, digits, "");
        return result;
    }

    private void helper(String[] alpha, List<String> result, String digits, String s) {
        if (digits.length() < 1) {
            result.add(s);
        } else {
            // 获取对象字符串
            String letters = alpha[digits.charAt(0) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                helper(alpha, result, digits.substring(1), s + letters.charAt(i));
            }
        }
    }

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