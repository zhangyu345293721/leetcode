package leetcode.select;


import org.junit.Test;

/**
 * 重复子字符串(这种方法可以，但是计算超时，需要换一种)
 *
 * @author: zhangyu
 */
public class RepeatedSubstring459 {
    @Test
    public void repeatedSubstring() {
        String s = "bb";
        boolean flag = repeatedSubstringPattern(s);
        System.out.println("flag = " + flag);
    }

    /**
     * 计算字符串是否是重复的子字符串
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        boolean flag = false;
        int end = s.length() / 2;
        for (int i = 1; i <= end; i++) {
            String sub = s.substring(0, i);
            int count = s.length() / sub.length();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++) {
                sb.append(sub);
            }
            if (sb.toString().equals(s)) {
                flag = true;
            }
        }
        return flag;
    }
}
