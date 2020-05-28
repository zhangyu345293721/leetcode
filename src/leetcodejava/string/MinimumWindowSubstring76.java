package leetcodejava.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 76 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-window-substring
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumWindowSubstring76 {

    @Test
    public void minimumWindowSubstringTest() {
        String s = "wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon";
        String t = "ozgzyywxvtublcl";
        String sub = minWindow(s, t);
        System.out.println(sub);
    }

    public String minWindow(String s, String t) {
        String minStr = s;
        Map<Character, Integer> map = getCharacterMap(t);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                Map<Character, Integer> subMap = getCharacterMap(sub);
                if (sub.equals(s)) {
                    if (!compareMapFlag(subMap, map)) {
                        return "";
                    }
                }
                boolean flag = compareMapFlag(subMap, map);
                if (flag) {
                    if (minStr.length() > sub.length()) {
                        minStr = sub;
                    }
                }
            }
        }
        return minStr.equals(s) ? "" : minStr;
    }

    private boolean compareMapFlag(Map<Character, Integer> subMap, Map<Character, Integer> map) {
        if (map == null || map.size() < 1) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            int num = entry.getValue();
            if ((!subMap.containsKey(ch)) || subMap.get(ch) < num) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharacterMap(String t) {
        if (t == null || t.length() < 1) {
            return new HashMap<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    Map<Character, Integer> map = new HashMap<>();  //记录t各个字母的数量
    Map<Character, Integer> map2 = new HashMap<>(); //记录当前范围内已获得的t中字母的数量

    public String minWindow2(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) {
            return "";
        }
        for (int i = 0; i < tlen; ++i) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //左边的指针用来指向窗口最左边的字母
        int start = -1;
        //记录最值，用来返回结果
        int begin = 0;
        int end = slen;
        for (int i = 0; i < slen; ++i) {
            char c = s.charAt(i);
            //如果当前在s中走到的字母是t中的字母就开始检查
            if (map.containsKey(c)) {
                if (start == -1) { //给start赋初值
                    start = i;
                }
                //窗口的右边每遇到一个t中的字母就记录
                map2.put(c, map2.getOrDefault(c, 0) + 1);

                //如果走到的字母跟范围的第一个字母相同就查看能不能把第一个字母消去（为了尽可能短）
                if (s.charAt(start) == c) {
                    while (start < i) {
                        char pre = s.charAt(start);
                        //检查start位置是不是t中的字母，如果不是就可以向右移
                        if (map.containsKey(pre)) {
                            //如果start位置是t中的字母，而且窗口内这个字母已经多过t中这个字母数量，那就可以舍去；
                            if (map.get(pre) < map2.get(pre)) {
                                map2.put(pre, map2.get(pre) - 1);
                            } else {  //否则就不能舍去，跳出检查
                                break;
                            }
                        }
                        ++start;
                    }
                }
                //判断当前的窗口是不是比较短且满足窗口内包括完了t中所有字母
                if (i - start < end - begin && check()) {
                    end = i;
                    begin = start;
                }
            }
        }
        return end == slen ? "" : s.substring(begin, end + 1);
    }

    boolean check() {                //用来检查当前的范围是否已包括完t中所有字母
        for (char c : map.keySet()) {
            if (map2.containsKey(c)) {
                if (map2.get(c) < map.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
