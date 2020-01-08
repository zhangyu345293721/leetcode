package leetcode.java.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 相同字符串
 *
 * @author: zhangyu
 * @date: 2020/01/07 21:48
 */
public class CommonCharacter1002 {
    @Test
    public void testCommonCharacter() {
        String[] strs = {"cool", "lock", "cook"};
        List<String> list = commonChars(strs);
        System.out.println(list);
    }

    /**
     * 计算重复字符
     *
     * @param A 数组
     * @return list
     */
    public List<String> commonChars(String[] A) {
        if (A.length < 1) {
            return new ArrayList<>();
        }
        if (A.length == 1) {
            return Arrays.asList(A[0].split(""));
        }
        List<String> list = new ArrayList<>();
        char[] chs = A[0].toCharArray();
        for (char ch : chs) {
            boolean flag = true;
            String chStr = String.valueOf(ch);
            for (int i = 1; i < A.length; i++) {
                if (A[i].contains(chStr)) {
                    A[i] = A[i].replaceFirst(chStr, "\\.");
                } else {
                    flag = false;
                }
            }
            if (flag) {
                list.add(chStr);
            }
        }
        return list;
    }
}
