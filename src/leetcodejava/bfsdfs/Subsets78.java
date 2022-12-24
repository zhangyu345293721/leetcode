package leetcodejava.bfsdfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.78 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subsets
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Subsets78 {
    @Test
    public void subsetsTest() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets4(nums);
        System.out.println(result);
        Assert.assertEquals(result.size(), 8);
    }

    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                // 复制一下，防止引用传递
                List<Integer> r = new ArrayList<>(result.get(i));
                r.add(num);
                result.add(r);
            }
        }
        return result;
    }

    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int len = 1; len <= nums.length; len++) {
            searchHelper2(nums, result, len, 0, new ArrayList<>());
        }
        return result;
    }

    /**
     * 回溯遍历
     *
     * @param nums   数组
     * @param result 结果链表
     * @param len    长度
     * @param index  下标
     * @param subset 子集
     */
    private void searchHelper2(int[] nums, List<List<Integer>> result, int len, int index, List<Integer> subset) {
        // 到了一定长度就退出
        if (subset.size() == len) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            searchHelper2(nums, result, len, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }


    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    public List<List<Integer>> subsets3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        searchHelper3(nums, result, 0, nums.length, new ArrayList<>());
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param nums   数组
     * @param result 结果链表
     * @param index  下标
     * @param temp   子集
     */
    public void searchHelper3(int[] nums, List<List<Integer>> result, int index, int len, List<Integer> temp) {
        // 复制链表，防止引用传递
        result.add(new ArrayList<>(temp));
        if (index == len) {
            return;
        }
        for (int i = index; i < len; i++) {
            temp.add(nums[i]);
            searchHelper3(nums, result, i + 1, len, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    public List<List<Integer>> subsets4(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        searchHelper4(nums, 0, new ArrayList<>());
        return result;
    }

    /**
     * 回溯
     *
     * @param nums 选或不选-可选列表
     * @param k    k阶段
     * @param path 路径
     */
    private void searchHelper4(int[] nums, int k, List<Integer> path) {
        if (k == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        // 不选择该数
        searchHelper4(nums, k + 1, path);
        path.add(nums[k]);
        // 选择则该数
        searchHelper4(nums, k + 1, path);
        path.remove(path.size() - 1);
    }
}
