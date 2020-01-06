package leetcode.string;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * 压缩字符串 LeetCode 443
 *
 * @author: zhangyu
 */
public class StringCompression {

    @Test
    public void testStringCompression() {
        String[] strs = {"a", "a", "b", "b", "c", "c", "c"};
        int num = compress(strs);
        System.out.println(num);
    }

    /**
     * 压缩字符串，把子串转成压缩形式
     *
     * @param chars 字符串数组
     * @return 长度
     */
    public int compress(String[] chars) {
        int pos = 0;
        List<String> list = new ArrayList();
        while (pos < chars.length) {
            int count = 1;
            while (pos < chars.length - 1 && chars[pos] == chars[pos + 1]) {
                pos++;
                count++;
            }
            if (count == 1) {
                list.add(String.valueOf(chars[pos]));
            } else {
                int length = String.valueOf(count).length();
                list.add(String.valueOf(chars[pos]));
                for (int i = 0; i < length; i++) {
                    char ch = String.valueOf(count).charAt(i);
                    list.add(String.valueOf(ch));
                }
            }
            pos++;
        }
        System.out.println(list);
        return list.size();
    }
}
