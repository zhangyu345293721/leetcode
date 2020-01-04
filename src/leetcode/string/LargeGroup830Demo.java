package leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将字符串按照相同字符切割分成链表
 *
 * @author: zhangyu
 */
public class LargeGroup830Demo {

    @Test
    public void fun() {
        String str = "abcdddeeeeaabbbcd";
        List<String> list = largeGroupPositions(str);
        System.out.println(list);
    }

    /**
     * 按照相同字符串进行切割
     *
     * @param S 最大输入串
     * @return 字符串分割后的链表
     */
    public List<String> largeGroupPositions(String S) {
        if (S == null || S.length() < 1) {
            return new ArrayList<>();
        }
        int i = 0;
        List<String> totalList = new ArrayList<>();
        while (i < S.length() - 1) {
            int start = i;
            while (start < S.length() - 1 && S.charAt(start) == S.charAt(start + 1)) {
                start++;
            }
            totalList.add(S.substring(i, start + 1));
            i = start + 1;
        }
        return totalList;
    }
}
