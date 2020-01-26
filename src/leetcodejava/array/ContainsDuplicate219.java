package leetcodejava.array;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * 包含重复的数
 *
 * @author: zhangyu
 */
public class ContainsDuplicate219 {

    @Test
    public void testContainsDuplicate() {
        int[] arr = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean flag = containsNearbyDuplicate2(arr, k);
        System.out.println(flag);
    }

    /**
     * 判断是否重复
     *
     * @param nums 数组
     * @param k    数
     * @return 布尔值
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否重复
     *
     * @param nums 数组
     * @param k    数
     * @return 布尔值
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (Math.abs(index - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
