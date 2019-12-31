package leetcode.select;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出最多气球个数(这种方法不行)
 *
 * @author: zhangyu
 */
public class MaximumNumberofBalloons1189 {

    @Test
    public void maximumNumberofBalloonsTestDemo() {
        String text = "nlaebolko";
        int count = maxNumberOfBalloons(text);
        System.out.println("count = " + count);
    }

    public int maxNumberOfBalloons(String text) {
        int count = 0;
        List<Character> matchList = getMatchListStr();
        for (char ch : text.toCharArray()) {
            if (matchList.contains(ch)) {
                matchList.remove(Character.valueOf(ch));
                if (matchList.isEmpty()) {
                    count++;
                    matchList = getMatchListStr();
                }
            }
        }
        return count;
    }

    /**
     * @return 返回有顺序字符串
     */
    private List<Character> getMatchListStr() {
        List<Character> list = new ArrayList<>();
        char[] chars = "balloon".toCharArray();
        for (Character ch : chars) {
            list.add(ch);
        }
        return list;
    }
}
