package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.557 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseWordsString557 {

    @Test
    public void reverseWordsStringTest() {
        String s = "Let's take LeetCode contest";
        String result = reverseWords(s);
        System.out.println(result);
        Assert.assertEquals(result,"s'teL ekat edoCteeL tsetnoc");
    }

    /**
     * 反转字符串
     *
     * @param s 字符串
     * @return 反转字符串
     */
    public String reverseWords(String s) {
        StringBuffer result = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = i - 1; p >= start; p--) {
                result.append(s.charAt(p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                result.append(' ');
            }
        }
        return result.toString();
    }

    /**
     * 反转字符串
     *
     * @param s 字符串
     * @return 反转字符串
     */
    public String reverseWords2(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String sub : strings) {
            sb.append(new StringBuffer(sub).reverse().toString() + " ");
        }
        return sb.toString().trim();
    }
}
