package java.string;


import org.junit.Test;

/**
 * 合法回文串
 *
 * @author: zhangyu
 */
public class ValidPalindrome125 {

    @Test
    public void validPalindromeTest() {
        //String str = "A man, a plan, a canal: Panama";
        String str = "0P";
        boolean flag = isPalindrome2(str);
        System.out.println(flag);
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
        return (s.charAt(index) >= 'a' && s.charAt(index) <= 'z') || (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') || (s.charAt(index) >= '0' && s.charAt(index) <= '9');
    }
}
