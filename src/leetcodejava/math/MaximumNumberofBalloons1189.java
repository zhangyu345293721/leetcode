package leetcodejava.math;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 1189 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-number-of-balloons
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 *  字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例 1：
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 * 输入：text = "loonbalxballpoon"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumNumberofBalloons1189 {

    @Test
    public void maximumNumberofBalloonsTest() {
        String text = "nlaebolko";
        int result = maxNumberOfBalloons(text);
        System.out.println(result);
    }

    /**
     * 找到最大个数
     *
     * @param text 输入字符串
     * @return 输出最大个数
     */
    public int maxNumberOfBalloons(String text) {
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
