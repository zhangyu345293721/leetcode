package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No.39 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CombinationSum39 {

    @Test
    public void combinationSumTest() {
        int[] candidates = {2, 3, 6, 7};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    List<List<Integer>> result = new ArrayList();

    /**
     * 获取所有的组合
     *
     * @param candidates 数组
     * @param target     目标值
     * @return 所有组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, current, 0);
        return result;
    }

    /**
     * 递归帮助类
     *
     * @param candidates 数组
     * @param target     目标值
     * @param current    当前链表
     * @param index      下标位置
     */
    private void helper(int[] candidates, int target, List<Integer> current, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            current.add(candidates[i]);
            if (target - candidates[i] == 0) {
                result.add(new ArrayList(current));
            } else {
                helper(candidates, target - candidates[i], current, i);
            }
            current.remove(current.size() - 1);
        }
    }

    /**
     * 获取所有的组合
     *
     * @param candidates 数组
     * @param target     目标值
     * @return 所有组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        helper2(candidates, target, result, current, 0);
        return result;
    }

    /**
     * 递归帮助类
     *
     * @param candidates 数组
     * @param target     目标值
     * @param result     结果链表
     * @param current    当前链表
     * @param index      下标位置
     */
    private void helper2(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                current.add(candidates[i]);
                result.add(new ArrayList(current));
            } else if (target > candidates[i]) {
                current.add(candidates[i]);
                helper2(candidates, target - candidates[i], result, current, i);
            } else {
                break;
            }
            current.remove(current.size() - 1);
        }
    }
}
