package leetcode.java.string;


import org.junit.Test;

/**
 * 长按名字
 *
 * @author: zhangyu
 */
public class LongPressed925 {
    @Test
    public void longPressed() {
        String name = "dfuyalc";
        String typed = "fuuyallc";
        boolean b = isLongPressedName(name, typed);
        System.out.println("b = " + b);
    }

    /**
     * 是不是长类型名字
     *
     * @param name  名字
     * @param typed 类型
     * @return 布尔值
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() < 1) {
            return false;
        }
        if (name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) {
            return false;
        }
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                if (j < typed.length()) {
                    j++;
                }
            } else {
                while (typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                }
                if (name.charAt(i) != typed.charAt(j)) {
                    return false;
                }
            }
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(i - 1)) {
                return false;
            }
            j++;
        }
        return j == typed.length();
    }
}
