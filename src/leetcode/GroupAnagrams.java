package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: GroupAnagrams
 * @Description: TOTO
 * @date 2018/12/14 16:56
 **/

/**
 * 基本思路是循环遍历每个元素，如果已经加入到list当中，那么就把该元素标记为“1”，下次看到“1”直接跳过
 */
public class GroupAnagrams {
    @Test
    public void fun() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
        System.out.println(Arrays.toString(strs));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> newList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("1"))
                continue;
            List<String> subList = new ArrayList<>();
            if (i < strs.length - 1) {
                subList.add(strs[i]);
                strs[i] = 1 + "";
            } else {
                if (!"1".equals(strs[i])) {
                    subList.add(strs[i]);
                    strs[i] = 1 + "";
                    newList.add(subList);
                    continue;
                }
            }
            for (int j = i + 1; j < strs.length; j++) {
                String test1 = sortString(strs[j]);
                if (sortString(strs[i]).equals(test1)) {
                    subList.add(strs[j]);
                    strs[j] = 1 + "";
                }
            }
            newList.add(subList);
        }
        return newList;
    }

    public String sortString(String s) {
        char chs[] = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}
