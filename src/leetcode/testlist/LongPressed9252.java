package leetcode.testlist;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 长按键(解决有些问题，没有考虑到相等的字符不在一起的情况) 如下：
 * "kikcxmvzi"
 * "kiikcxxmmvvzz"
 *
 * @author: zhangyu
 * @date: 2019/11/11 22:28
 */
public class LongPressed9252 {

    @Test
    public void longPressedTestDemo() {
        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        boolean b = isLongPressedName(name, typed);
        System.out.println("b = " + b);
    }

    /**
     * @param name  名字
     * @param typed 类型
     * @return 布尔值
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() < 1) {
            return false;
        }
        if (typed == null || typed.length() < 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);
            if (ch1 == ch2) {
                i++;
                j++;
            }
        }
        return true;
    }
}
