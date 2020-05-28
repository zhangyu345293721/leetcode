package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No.748 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/shortest-completing-word
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 *
 * 示例 1：
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 *  
 * 示例 2：
 *
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 *  
 * 注意:
 *
 * 牌照（licensePlate）的长度在区域[1, 7]中。
 * 牌照（licensePlate）将会包含数字、空格、或者字母（大写和小写）。
 * 单词列表（words）长度在区间 [10, 1000] 中。
 * 每一个单词 words[i] 都是小写，并且长度在区间 [1, 15] 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
