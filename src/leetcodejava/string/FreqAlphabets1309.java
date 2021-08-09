package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the solution of No. 1309 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 * <p>
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 * <p>
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FreqAlphabets1309 {

    @Test
    public void freqAlphabetsTest() {
        String s = "25#";
        String result = freqAlphabets(s);
        System.out.println(result);
        Assert.assertEquals(result, "y");
    }

    /**
     * 对字符串进行处理
     *
     * @param s 字符串
     * @return 编码后字符串
     */
    public String freqAlphabets(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        List<Character> characters = new ArrayList<>();
        int index = 0;
        int length = s.length();
        while (index < length) {
            String sub = null;
            if (index + 2 < length && s.charAt(index + 2) == '#') {
                sub = s.substring(index, index + 3);
                index += 3;
            } else {
                sub = s.substring(index, index + 1);
                index++;
            }
            char ch = getReverseChar(sub);
            characters.add(ch);
        }
        return characters.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(""));
    }

    /**
     * 将字符串转成目标字符
     *
     * @param sub 子字符串
     * @return 字符
     */
    private char getReverseChar(String sub) {
        if (sub.contains("#")) {
            String s = sub.substring(0, sub.length() - 1);
            return (char) (Integer.valueOf(s) + 96);
        }
        return (char) (Integer.valueOf(sub) + 96);
    }
}
