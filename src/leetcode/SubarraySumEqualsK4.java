package leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SubarraySumEqualsK
 * @Description: TOTO
 * @date 2018/12/11 10:22
 **/

public class SubarraySumEqualsK4 {
    @Test
    public void fun() {
        int nums[] = {1, 2, 3, 3};
        int k = 3;
        int key = subarraySum(nums, k);
        System.out.println(key);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            /*if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }*/
        }
        return count;
    }
}
