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
 */
public class LongPressed925 {

    @Test
    public void longPressedTestDemo() {
        String name = "leelee";
        String typed = "lleeelee";
        boolean b = isLongPressedName(name, typed);
        System.out.println("b = " + b);
    }

    /**
     * 是不是长压字符串
     *
     * @param name  名字
     * @param typed 类型
     * @return 布尔值
     */
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

    /**
     * @param name  名字
     * @param typed 类型
     * @return 布尔值
     */
    public boolean isLongPressedName2(String name, String typed) {
        if (name == null || name.length() < 1) {
            return false;
        }
        if (typed == null || typed.length() < 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);
            if (ch1 == ch2) {
                i++;
                j++;
            }
        }
        return true;
    }
}
