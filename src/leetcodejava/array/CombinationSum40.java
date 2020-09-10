package leetcodejava.array;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 40 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CombinationSum40 {

    @Test
    public void combinationSumTest() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }

    /**
     * 包含不重复目标和
     *
     * @param candidates 候选数组
     * @param target     目标数
     * @return 结果集
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, result, temp, 0);
        return result;
    }

    /**
     * 递归查找数，深度优先遍历
     *
     * @param candidates 候选数组
     * @param target     目标值
     * @param result     结果链表
     * @param temp       临时链表
     * @param index      下标
     */
    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[index] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 包含不重复目标和
     *
     * @param candidates 候选数组
     * @param target     目标数
     * @return 结果集
     */
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper2(candidates, target, result, temp, 0);
        return result;
    }

    /**
     * 递归查找数，深度优先遍历
     *
     * @param candidates 候选数组
     * @param target     目标值
     * @param result     结果链表
     * @param temp       临时链表
     * @param index      下标
     */
    private void helper2(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            /**
             * 过滤掉相同的数组
             */
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            if (target - candidates[i] == 0) {
                result.add(new ArrayList<>(temp));
            } else {
                /**
                 * 加1目的，防止一个数字出现几次
                 */
                helper2(candidates, target - candidates[i], result, temp, i + 1);
            }
            temp.remove(temp.size() - 1);
        }
    }
}
