package java.math;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找出最多气球个数
 *
 * @author: zhangyu
 */
public class MaximumNumberofBalloons11892 {

    @Test
    public void maximumNumberofBalloonsTestDemo() {
        String text = "nlaebolko";
        int count = maxNumberOfBalloons(text);
        System.out.println(count);
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
