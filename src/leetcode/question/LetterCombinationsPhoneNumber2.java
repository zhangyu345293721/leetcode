package leetcode.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu  // 这种思路不可行，
 * @version V1.0
 * @ClassName: LetterCombinationsPhoneNumber
 * @Description: TOTO
 * @date 2018/11/26 15:37
 **/


public class LetterCombinationsPhoneNumber2 {
    @Test
    public void fun() {
        String digits = "23";
        List<String> list = letterCombinationsPhoneNumber(digits);
        System.out.println(list);
    }

    // 获取链表长度的list，然后再进行买个遍历
    private List<String> letterCombinationsPhoneNumber(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() < 1) {
            return list;
        }
        char[] chDigits = digits.toCharArray();
        return helper(list, "", 0, chDigits);
    }

    private List<String> helper(List<String> list, String s, int index, char[] chs) {
        String subS = getString(chs[index]);
        // String s = "";
        if (s.length() == chs.length) {
            list.add(s);
        }else{
            if (index < chs.length) {
                for (int i = 0; i < subS.length(); i++) {
                    s += subS.charAt(i);
                    helper(list, s +"", index + 1, chs);
                }
            }
        }
        return list;
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
