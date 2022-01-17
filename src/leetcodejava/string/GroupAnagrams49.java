package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 49 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/group-anagrams
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class GroupAnagrams49 {
    @Test
    public void groupAnagramsTest() {
        String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        List<List<String>> result = groupAnagrams4(strs);
        System.out.println(result);
        Assert.assertEquals(result.get(0).get(0), "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }


    /**
     * 生成镶嵌链表
     *
     * @param strs 字符串数组
     * @return 链表
     */
    private List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }

    /**
     * 生成镶嵌链表
     *
     * @param strs 字符串数组
     * @return 链表
     */
    private List<List<String>> groupAnagrams4(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
        HashMap<Double, List<String>> map = new HashMap<>();
        for (String s : strs) {
            double key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> t = new ArrayList<>();
                t.add(s);
                map.put(key, t);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 生成镶嵌链表
     *
     * @param strs 字符串数组
     * @return 链表
     */
    private List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 生成镶嵌链表
     *
     * @param strs 字符串数组
     * @return 链表
     */
    private List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String newStr = getSortedStr(str);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 字符串进行排序
     *
     * @param s 字符串
     * @return 排序好的字符串
     */
    public String getSortedStr(String s) {
        char chs[] = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}
