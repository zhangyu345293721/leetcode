package leetcodejava.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找出一个数组中没有出现的数字
 *
 * @author zhangyu
 **/


public class FindDisappearedNumbers448 {
    @Test
    public void testFindDisappearedNumbers() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }

    /**
     * 找失去数字
     *
     * @param nums 数组
     * @return 链表
     */
    private List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 找失去数字
     *
     * @param nums 数组
     * @return 链表
     */
    private List<Integer> findDisappearedNumbers2(int[] nums) {
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
