package leetcode.java.math;

import org.junit.Test;

/**
 * 分成几个单词
 *
 * @author: zhangyu
 */
public class NumberSegments434 {
    @Test
    public void numberSegmentsTestDemo() {
        String str = "    foo    bar";
        int count = countSegments(str);
        System.out.println(count);
    }

    /**
     * 对字符串进行划分
     *
     * @param s 输入字符串
     * @return  划分个数
     */
    public int countSegments(String s) {
        if (s == null || s.trim().length() < 1) {
            return 0;
        }
        String[] strs = s.trim().split("[ ]+");
        return strs.length;
    }
}
