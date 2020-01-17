package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 只出现一次数字
 *
 * @author: zhangyu
 */
public class UniqueNumberOccurrences1207 {

    @Test
    public void testUniqueNumberOccurrences() {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean flag = uniqueOccurrences(arr);
        System.out.println(flag);
    }

    /**
     * 独特发生的次数
     *
     * @param arr 数组
     * @return 布尔值
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
        }
        return set.size() == map.size();
    }
}
