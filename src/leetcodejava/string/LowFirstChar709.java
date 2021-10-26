package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.709 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/to-lower-case
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 * <p>
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 * <p>
 * 输入: "LOVELY"
 * 输出: "lovely"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LowFirstChar709 {
    @Test
    public void lowFirstCharTest() {
        String s = "ABC";
        String result = lowFirstChar2(s);
        System.out.println(result);
       Assert.assertEquals(result,"abc");
    }

    /**
     * 将字符串变成大写开头
     *
     * @param s 字符串
     * @return 字符串
     */
    private String lowFirstChar(String s) {
        if (s == null && s.length() == 0) {
            return "";
        }
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[i] = (char) (chs[i] + ('a' - 'A'));
            }
        }
        return String.valueOf(chs);
    }

    /**
     * 将字符串变成大写开头
     *
     * @param s 字符串
     * @return 字符串
     */
    private String lowFirstChar2(String s) {
        return s.toLowerCase();
    }
}
