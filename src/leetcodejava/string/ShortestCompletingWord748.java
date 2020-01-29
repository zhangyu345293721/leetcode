package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最短比较字符串
 *
 * @author: zhangyu
 */
public class ShortestCompletingWord748 {


    @Test
    public void testShortestCompletingWord() {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    /**
     * 查找最最短的匹配串
     * @param licensePlate 匹配串
     * @param words 单词
     * @return 最短单词
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> licenseMap = getLicenseMap(licensePlate);
        List<String> list = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> map = getLicenseMap(word);
            boolean flag = compareString(licenseMap, map);
            if (flag) {
                list.add(word);
            }
        }
        String shortestStr = getShortestString(list);
        return shortestStr;
    }

    /**
     * 获取最短字符串
     *
     * @param list 链表
     * @return 字符串
     */
    private String getShortestString(List<String> list) {
        String min = list.get(0);
        for (String str : list) {
            if (min.length() > str.length()) {
                min = str;
            }
        }
        return min;
    }

    /**
     * 比较两个字符串比较
     *
     * @param licenseMap 字符串map1
     * @param map        map2
     * @return 布尔值
     */
    private boolean compareString(Map<Character, Integer> licenseMap, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : licenseMap.entrySet()) {
            if (!map.containsKey(entry.getKey()) || map.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取字符串map
     *
     * @param licensePlate 字符串
     * @return map
     */
    private Map<Character, Integer> getLicenseMap(String licensePlate) {
        Map<Character, Integer> map = new HashMap<>();
        String license = getLicenseString(licensePlate);
        for (char ch : license.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    /**
     * 获取字符串
     *
     * @param licensePlate 输入字符串
     * @return license字符串
     */
    private String getLicenseString(String licensePlate) {
        StringBuffer sb = new StringBuffer();
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
