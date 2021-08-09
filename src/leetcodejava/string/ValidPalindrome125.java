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
        //String str = "A man, a plan, a canal: Panama";
        String str = "0P";
        boolean result = isPalindrome2(str);
        System.out.println(result);
        Assert.assertEquals(result, false);
    }

    /**
     * 判断是不是回文组
     *
     * @param s 要判断字符串
     * @return 布尔类型值
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            boolean flag1 = getValidFlag(s, i);
            boolean flag2 = getValidFlag(s, j);
            if (flag1 && flag2) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            } else if (flag1 == false && flag2 == true) {
                i++;
            } else if (flag1 == true && flag2 == false) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return true;
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
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
    }


    /**
     * 判断是不是
     *
     * @param s     输入串
     * @param index 下标
     * @return 返回flag
     */
    private boolean getValidFlag(String s, int index) {
        return (s.charAt(index) >= 'a' && s.charAt(index) <= 'z') || (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z')
                || (s.charAt(index) >= '0' && s.charAt(index) <= '9');
    }

    /**
     * 判断是不是回文组
     *
     * @param s 要判断字符串
     * @return 布尔类型值
     */
    public boolean isPalindrome3(String s) {
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
}
