package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is the solution of No. 40 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
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
        int[] candidates = {5,3,2,1,1,4};
        int target = 10;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
        Assert.assertEquals(result.size(), 1);
    }


    /**
     * 包含不重复目标和
     *
     * @param candidates 候选数组
     * @param target     目标数
     * @return 结果集
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        //Arrays.sort(candidates);
        searchHelper1(candidates, target, result, temp, 0);
        return result.stream().collect(Collectors.toList());
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
    public void searchHelper1(int[] candidates, int target, Set<List<Integer>> result, List<Integer> temp, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            if (target - candidates[i] == 0) {
                result.add(new ArrayList<>(temp));
            } else {
                /**
                 * 加1目的，防止一个数字出现几次
                 */
                searchHelper1(candidates, target - candidates[i], result, temp, i + 1);
            }
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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        searchHelper2(candidates, target, result, temp, 0);
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
    private void searchHelper2(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[index] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 回溯
            temp.add(candidates[i]);
            searchHelper2(candidates, target - candidates[i], result, temp, i + 1);
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
        searchHelper3(candidates, target, result, temp, 0);
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
    private void searchHelper3(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
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
                return;
            } else {
                /**
                 * 加1目的，防止一个数字出现几次
                 */
                searchHelper3(candidates, target - candidates[i], result, temp, i + 1);
            }
            temp.remove(temp.size() - 1);
        }
    }
}
