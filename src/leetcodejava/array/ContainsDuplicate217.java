package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 数组中是否包含重复的数
 *
 * @author: zhangyu
 */
public class ContainsDuplicate217 {

    @Test
    public void testContainsDuplicate() {
        int[] arr = {1, 2, 3, 4};
        boolean flag = containsDuplicate(arr);
        System.out.println(flag);
    }

    /**
     * 数组中是否包含重复的数
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组中是否包含重复的数
     *
     * @param nums 数组
     * @return 布尔值
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
