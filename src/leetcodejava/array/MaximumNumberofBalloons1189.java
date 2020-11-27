package leetcodejava.array;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 1189 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-number-of-balloons
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumNumberofBalloons1189 {

    @Test
    public void maximumNumberofBalloonsTest() {
        String text = "nlaebolko";
        int count = maxNumberOfBalloons(text);
        System.out.println("count = " + count);
    }

    /**
     * 最大气球数量
     *
     * @param text 字符串
     * @return 数量
     */
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

    /**
     * 找到最大个数
     *
     * @param text 输入字符串
     * @return 输出最大个数
     */
    public int maxNumberOfBalloons2(String text) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map1 = getMap("balloon");
        Map<Character, Integer> map2 = getMap(text);
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character ch = entry.getKey();
            if (map2.containsKey(ch)) {
                int num1 = map1.get(ch);
                int num2 = map2.get(ch);
                list.add(num2 / num1);
            } else {
                return 0;
            }
        }
        return list.stream().mapToInt(e -> e).min().getAsInt();

    }

    /**
     * 统计字符出现次数
     */
    private Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (Character ch : chars) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}
