package java.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大的分组下标
 *
 * @author: zhangyu
 */
public class LargeGroup830 {

    @Test
    public void fun() {
        String str = "abcdddeeeeaabbbcd";
        List<List<Integer>> list = largeGroupPositions(str);
        System.out.println(list);
    }

    /**
     * 最大的分组下标
     *
     * @param S 输入字符串
     * @return 最大下标链表
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() < 1) {
            return new ArrayList<>();
        }
        int i = 0;
        List<List<Integer>> totalList = new ArrayList<>();
        while (i < S.length() - 1) {
            int start = i;
            int count = 1;
            while (start < S.length() - 1 && S.charAt(start) == S.charAt(start + 1)) {
                count++;
                start++;
            }
            if (count >= 3) {
                List<Integer> positionList = new ArrayList<>();
                positionList.add(i);
                positionList.add(start);
                totalList.add(positionList);
            }
            i = start + 1;
        }
        return totalList;
    }
}
