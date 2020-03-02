package leetcodejava.top100likedquestions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 获取所有组合
 *
 * @author: zhangyu
 */
public class CombinationSum39 {

    @Test
    public void testCombinationSum() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = combinationSum(candidates, target);
        System.out.println(list);
    }

    /**
     * 获取所有的组合
     *
     * @param nums   数组
     * @param target 目标值
     * @return 所有组合
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, result, current, 0);
        return result;
    }

    /**
     * 递归帮助类
     *
     * @param nums    数组
     * @param target  目标值
     * @param result  结果链表
     * @param current 当前链表
     * @param index   下标位置
     */
    private void helper(int[] nums, int target, List<List<Integer>> result, List<Integer> current, int index) {
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            current.add(nums[i]);
            if (target - nums[i] == 0) {
                result.add(new ArrayList(current));
            } else {
                helper(nums, target - nums[i], result, current, i);
            }
            current.remove(current.size() - 1);
        }
    }
}
