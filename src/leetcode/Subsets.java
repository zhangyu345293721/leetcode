package leetcode;

import org.junit.Test;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Subsets
 * @Description: TOTO
 * @date 2018/12/7 11:36
 **/

// 这种循环方式是错误的，没有考虑到所有情况
public class Subsets {
    @Test
    public void fun() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sList = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                boolean flag = true;
                List<Integer> subList = getSubList(nums, i, j);
                if (subList != null) {
                    list.add(subList);
                }
                if (subList == null && flag) {
                    list.add(subList);
                    flag = false;
                }
            }
            list.add(sList);
        }
        return list;
    }

    private List<Integer> getSubList(int[] nums, int left, int right) {
        List<Integer> subList = new ArrayList<>();
        for (int i = left; i < right; i++) {
            subList.add(nums[i]);
        }
        return subList;
    }
}
