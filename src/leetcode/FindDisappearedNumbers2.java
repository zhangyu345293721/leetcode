package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: FindDisappearedNumbers
 * @Description: 找出一个数组中没有出现的数字
 * @date 2018/12/2 19:40
 **/


public class FindDisappearedNumbers2 {
    @Test
    public void fun() {
        int[] nums = {1, 2, 2};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }

    private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        for (int num : nums) {    // 这是一种转换的技巧算法，非常实用，但是难以想到
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}
