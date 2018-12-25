package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: GroupAnagrams
 * @Description: TOTO
 * @date 2018/12/14 16:56
 **/

/**
 * 利用字符数的转换
 */
public class GroupAnagrams3 {
    @Test
    public void fun() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String newStr = new String(chs);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<String>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList(map.values());
    }
}
