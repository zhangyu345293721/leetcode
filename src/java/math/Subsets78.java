package java.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 **/

public class Subsets78 {
    @Test
    public void testSubsets() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }


    /**
     * 子集
     *
     * @param nums 数组
     * @return 子集
     */
    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subsets(nums, 0, subList, list);
        return list;
    }

    private void subsets(int[] nums, int i, List<Integer> subList, List<List<Integer>> list) {
        if (i == nums.length) {
            list.add(subList);
            return;
        }
        int num = nums[i];
        List<Integer> temp = new ArrayList<>(subList);
        temp.add(num);
        subsets(nums, i + 1, temp, list);
        subsets(nums, i + 1, subList, list);
        return;
    }

    /**
     * @param nums 数组
     * @return 链表
     */
    private List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int[] pos = new int[nums.length];
        int index = 0;
        pos[0] = -1;
        while (index >= 0) {
            pos[index]++;
            if (pos[index] < nums.length) {
                List<Integer> s = new ArrayList<Integer>();
                for (int ii = 0; ii <= index; ii++) {
                    s.add(nums[pos[ii]]);
                }
                ret.add(s);
                if (index < nums.length - 1) {
                    index++;
                    pos[index] = pos[index - 1];
                }
                continue;
            }
            index--;
        }
        ret.add(new ArrayList());
        return ret;
    }
}
