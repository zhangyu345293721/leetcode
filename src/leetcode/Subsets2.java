package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Subsets
 * @Description: TOTO
 * @date 2018/12/7 10:32
 **/

// 这种利用递归的方式
public class Subsets2 {
    @Test
    public void fun() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subsets(nums, 0, subList, list);
        return  list;
    }

    private void subsets(int[] nums, int i, List<Integer> subList, List<List<Integer>> list){
        if (i == nums.length) {
            list.add(subList);
            return;
        }
        int num = nums[i];
        List<Integer> temp = new ArrayList<>(subList);
        temp.add(num);
        subsets(nums, i+1, temp, list);
        subsets(nums, i+1, subList, list);
        return;
    }
}
