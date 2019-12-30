package leetcode.testlist;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 长按键(解决有些问题，没有考虑到相等的字符不在一起的情况) 如下：
 * "kikcxmvzi"
 * "kiikcxxmmvvzz"
 *
 * @author: zhangyu
 * @date: 2019/11/11 22:28
 */
public class LongPressed925 {

    @Test
    public void longPressedTestDemo() {
        String name = "leelee";
        String typed = "lleeelee";
        boolean b = isLongPressedName(name, typed);
        System.out.println("b = " + b);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() < 1) {
            return false;
        }
        if (typed == null || typed.length() < 1) {
            return false;
        }
        Map<Character, Integer> nameMap = getLocationNumberMap(name);
        Map<Character, Integer> typedMap = getLocationNumberMap(typed);

        if (!nameMap.keySet().equals(typedMap.keySet())) {
            return false;
        }
        for (Character ch : nameMap.keySet()) {
            if (typedMap.get(ch) < nameMap.get(ch)) {
                return false;
            }
        }
        return true;


    }

    /**
     * 将字符串变成linkedhashMap
     *
     * @param str 输入字符串
     * @return map
     */
    private Map<Character, Integer> getLocationNumberMap(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}
