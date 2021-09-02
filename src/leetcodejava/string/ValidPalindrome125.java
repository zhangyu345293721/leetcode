package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.125 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/valid-palindrome
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ValidPalindrome125 {

    @Test
    public void validPalindromeTest() {
        String str = "A man, a plan, a canal: Panama";
        // String str = "0P";
        boolean result = isPalindrome2("A man, a plan, a canal: Panama");
        System.out.println(result);
        Assert.assertEquals(result, false);
    }

    /**
     * 判断是不是回文组
     *
     * @param s 要判断字符串
     * @return 布尔类型值
     */
    public boolean isPalindrome1(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    /**
     * 判断是不是回文组
     *
     * @param s 要判断字符串
     * @return 布尔类型值
     */
    public boolean isPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        char chs[] = s.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            if (!isValidChar(chs[i])) {
                i++;
                continue;
            }
            if (!isValidChar(chs[j])) {
                j--;
                continue;
            }
            if (toLowerChar(chs[i]) != toLowerChar(chs[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 判断是否是合法字符
     *
     * @param ch 字符
     * @return 布尔值
     */
    public boolean isValidChar(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }

    /**
     * 将大写字母变成小写
     *
     * @param ch 字符
     * @return 小写字符
     */
    public char toLowerChar(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch;
        }
        if (ch >= 'a' && ch <= 'z') {
            return ch;
        }
        return (char) (ch + 32);
    }
}
