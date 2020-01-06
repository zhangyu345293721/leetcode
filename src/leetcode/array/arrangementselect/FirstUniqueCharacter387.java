package leetcode.array.arrangementselect;


import org.junit.Test;

/**
 * 找出没有重复字符
 *
 * @author: zhangyu
 */
public class FirstUniqueCharacter387 {

    @Test
    public void firstAppearDemo() {
        String s = "aadadaae";
        int index = getFirstUniqueCharacterIndex(s);
        System.out.println(index);
    }

    /**
     * 不重复字符串下标
     *
     * @param s 字符串
     * @return 字符串下标
     */
    private int getFirstUniqueCharacterIndex(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        // 中间出现
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String sub = s.substring(i + 1);
            String subStart = s.substring(0, i);
            if (sub.indexOf(ch) == -1 && subStart.indexOf(ch) == -1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 字符串下标
     *
     * @param s 字符串
     * @return 下标
     */
    private int getFirstUniqueCharacterIndex2(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        for (char ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }
}
