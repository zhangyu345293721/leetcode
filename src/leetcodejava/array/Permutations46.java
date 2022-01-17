package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.46 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/permutations
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Permutations46 {

    @Test
    public void permutationsTest() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
        Assert.assertEquals(result.size(), 6);
    }

    /**
     * 全排列
     *
     * @param nums 数组
     * @return result
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList();
        }
        int len = nums.length;
        List<List<Integer>> result = new ArrayList();
        boolean[] visited = new boolean[len];
        searchHelper(result, new ArrayList(), nums, visited);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param result 结果集
     * @param temp   临时结果集
     * @param nums   数组
     */
    public void searchHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean visited[]) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            searchHelper(result, temp, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 全排列
     *
     * @param nums 数组
     * @return result
     */
    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path);
        return result;
    }

    /**
     * 回溯
     *
     * @param nums nums中除掉存在于path中的数据
     * @param k    决策阶段
     * @param path 记录在path中
     */
    private void backtrack(int[] nums, int k, List<Integer> path) {
        // 结束条件
        if (k == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (path.contains(nums[i])) {
                continue;
            }
            // 做选择
            path.add(nums[i]);
            // 递归
            backtrack(nums, k + 1, path);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
