package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 第三种方式计算三个数的值
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: ThreeSum
 * @Description: TOTO
 * @date 2018/12/3 17:12
 **/


public class ThreeSum3 {
    @Test
    public void fun() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = getList(nums);
        System.out.println(list);
    }

    private List<List<Integer>> getList(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
